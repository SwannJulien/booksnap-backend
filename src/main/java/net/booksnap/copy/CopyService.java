package net.booksnap.copy;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.booksnap.book.Book;
import net.booksnap.book.BookRepository;
import net.booksnap.library.Library;
import net.booksnap.qr.QRCodeService;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class CopyService {

    private final CopyRepository copyRepository;
    private final BookRepository bookRepository;
    private final QRCodeService qrCodeService;
    private final CopyMapper copyMapper;
    private final ObjectMapper objectMapper;

    public CopyService(CopyRepository copyRepository, 
                       BookRepository bookRepository,
                       QRCodeService qrCodeService,
                       CopyMapper copyMapper,
                       ObjectMapper objectMapper) {
        this.copyRepository = copyRepository;
        this.bookRepository = bookRepository;
        this.qrCodeService = qrCodeService;
        this.copyMapper = copyMapper;
        this.objectMapper = objectMapper;
    }

    public Copy createCopy(CopyDTO copyDTO) {
        Book book = bookRepository.findById(copyDTO.getBookId())
            .orElseThrow(() -> new RuntimeException("Book not found with ID: " + copyDTO.getBookId()));

        Copy copy = new Copy();
        copy.setBook(book);
        copy.setLibrary(new Library(copyDTO.getLibraryId(), null));
        copy.setStatus(copyDTO.getStatus());
        copy.setCodeIdentification("TEMP"); // Temporary placeholder to satisfy @NotNull

        Copy savedCopy = copyRepository.save(copy);

        // Generate QR code identification after saving to get the ID
        String qrCodeIdentification = qrCodeService.generateCopyIdentificationCode(savedCopy);
        savedCopy.setCodeIdentification(qrCodeIdentification);
        
        return copyRepository.save(savedCopy);
    }

    public byte[] generateQRCodeImage(Long copyId) {
        Copy copy = findCopyEntityById(copyId);
        return qrCodeService.generateCopyQRCode(copy);
    }

    public Object findById(Long copyId, String fields) {
        Copy copy = copyRepository.findById(copyId)
            .orElseThrow(() -> new RuntimeException("Copy not found with ID: " + copyId));
        CopyDTO copyDTO = copyMapper.copyToDTO(copy);
        
        if (fields == null || fields.trim().isEmpty()) {
            return copyDTO;
        }
        
        try {
            JsonNode fullNode = objectMapper.valueToTree(copyDTO);
            ObjectNode filteredNode = objectMapper.createObjectNode();
            
            Set<String> requestedFields = new HashSet<>(Arrays.asList(fields.split(",")));
            
            for (String field : requestedFields) {
                String trimmedField = field.trim();
                if (fullNode.has(trimmedField)) {
                    filteredNode.set(trimmedField, fullNode.get(trimmedField));
                }
            }
            
            return filteredNode;
        } catch (Exception e) {
            throw new RuntimeException("Error filtering fields: " + e.getMessage(), e);
        }
    }

    public Copy findCopyEntityById(Long copyId) {
        return copyRepository.findById(copyId)
            .orElseThrow(() -> new RuntimeException("Copy not found with ID: " + copyId));
    }
}