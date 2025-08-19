package net.booksnap.copy.service;

import net.booksnap.book.Book;
import net.booksnap.book.repository.BookRepository;
import net.booksnap.copy.Copy;
import net.booksnap.copy.api.dto.CreateCopyRequest;
import net.booksnap.copy.api.dto.CopyResponse;
import net.booksnap.copy.mapper.CopyApiMapper;
import net.booksnap.copy.repository.CopyRepository;
import net.booksnap.exception.book.BookNotFoundException;
import net.booksnap.exception.copy.CopyNotFoundException;
import net.booksnap.library.Library;
import net.booksnap.qr.QRCodeService;
import net.booksnap.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class CopyServiceImpl implements CopyService {

    private final CopyRepository copyRepository;
    private final BookRepository bookRepository;
    private final QRCodeService qrCodeService;
    private final CopyApiMapper copyApiMapper;
    private final Utils utils;

    public CopyServiceImpl(CopyRepository copyRepository,
                           BookRepository bookRepository,
                           QRCodeService qrCodeService,
                           CopyApiMapper copyApiMapper,
                           Utils utils) {
        this.copyRepository = copyRepository;
        this.bookRepository = bookRepository;
        this.qrCodeService = qrCodeService;
        this.copyApiMapper = copyApiMapper;
        this.utils = utils;
    }

    public Copy createCopy(CreateCopyRequest createCopyRequest) {
        Book book = bookRepository.findById(createCopyRequest.bookId())
            .orElseThrow(() -> new BookNotFoundException(createCopyRequest.bookId()));

        Copy copy = new Copy();
        copy.setBook(book);
        copy.setLibrary(new Library(createCopyRequest.libraryId(), null));
        copy.setStatus(createCopyRequest.status());
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

    public Object findCopyById(Long copyId, String fields) {
        Copy copy = copyRepository.findById(copyId)
            .orElseThrow(() -> new CopyNotFoundException(copyId));
        CopyResponse copyResponse = copyApiMapper.copyToResponse(copy);


        if (fields == null || fields.trim().isEmpty()) {
            return copyResponse;
        }
        
        try {
            return utils.filterFields(copyResponse, fields);
        } catch (Exception e) {
            throw new RuntimeException("Error filtering fields: " + e.getMessage(), e);
        }
    }

    public Copy findCopyEntityById(Long copyId) {
        return copyRepository.findById(copyId)
            .orElseThrow(() -> new RuntimeException("Copy not found with ID: " + copyId));
    }
}