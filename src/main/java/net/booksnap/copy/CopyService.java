package net.booksnap.copy;

import net.booksnap.book.Book;
import net.booksnap.book.BookRepository;
import net.booksnap.library.Library;
import net.booksnap.qr.QRCodeService;
import org.springframework.stereotype.Service;

@Service
public class CopyService {

    private final CopyRepository copyRepository;
    private final BookRepository bookRepository;
    private final QRCodeService qrCodeService;
    private final CopyMapper copyMapper;

    public CopyService(CopyRepository copyRepository, 
                       BookRepository bookRepository,
                       QRCodeService qrCodeService,
                       CopyMapper copyMapper) {
        this.copyRepository = copyRepository;
        this.bookRepository = bookRepository;
        this.qrCodeService = qrCodeService;
        this.copyMapper = copyMapper;
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

    public CopyDTO findById(Long copyId) {
        Copy copy = copyRepository.findById(copyId)
            .orElseThrow(() -> new RuntimeException("Copy not found with ID: " + copyId));
        return copyMapper.copyToDTO(copy);
    }

    public Copy findCopyEntityById(Long copyId) {
        return copyRepository.findById(copyId)
            .orElseThrow(() -> new RuntimeException("Copy not found with ID: " + copyId));
    }
}