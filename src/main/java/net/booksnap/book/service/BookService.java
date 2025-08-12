package net.booksnap.book.service;

import net.booksnap.book.Book;
import net.booksnap.book.mapper.BookBusinessMapper;
import net.booksnap.book.repository.BookRepository;
import net.booksnap.book.service.dto.BookBusinessDTO;
import net.booksnap.copy.Copy;
import net.booksnap.copy.CopyRepository;
import net.booksnap.copy.Status;
import net.booksnap.exception.dewey.DeweyCodeNotFoundException;
import net.booksnap.exception.dewey.FictionBookHasDeweyCodeException;
import net.booksnap.library.Library;
import net.booksnap.qr.QRCodeService;
import net.booksnap.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookBusinessMapper businessMapper;
    private final CopyRepository copyRepository;
    private final QRCodeService qrCodeService;
    private final Utils utils;

    public BookService(BookRepository bookRepository,
                       BookBusinessMapper businessMapper,
                       CopyRepository copyRepository,
                       QRCodeService qrCodeService,
                       Utils utils) {
        this.bookRepository = bookRepository;
        this.businessMapper = businessMapper;
        this.copyRepository = copyRepository;
        this.qrCodeService = qrCodeService;
        this.utils = utils;
    }

    public void addBook(BookBusinessDTO businessDTO) {
        try {
            Book book = businessMapper.businessDTOToEntity(businessDTO);
            Book savedBook = bookRepository.save(book);

            Copy copy = new Copy();
            copy.setBook(savedBook);
            copy.setLibrary(new Library(businessDTO.getLibraryId(), null));
            copy.setStatus(Status.available);
            copy.setCodeIdentification("TEMP"); // Temporary placeholder to satisfy @NotNull
            
            Copy savedCopy = copyRepository.save(copy);
            
            // Generate QR code identification after saving to get the ID
            String qrCodeIdentification = qrCodeService.generateCopyIdentificationCode(savedCopy);
            savedCopy.setCodeIdentification(qrCodeIdentification);
            copyRepository.save(savedCopy);
            
        } catch (Exception e) {
            if (e.getMessage().contains("non_fiction_requires_dewey")) {
                throw new FictionBookHasDeweyCodeException();
            } else if (e.getMessage().contains("persistent instance references an unsaved transient instance of 'net.booksnap.dewey.Dewey'")) {
                throw new DeweyCodeNotFoundException(businessDTO.getCodeDewey());
            } else throw e;
        }
    }

    public BookBusinessDTO findById(Long bookId) {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));
        return businessMapper.entityToBusinessDTO(book);
    }

    public Object findByIdWithFields(Long bookId, String fields) {
        BookBusinessDTO businessDTO = findById(bookId);
        try {
            return utils.filterFields(businessDTO, fields);
        } catch (Exception e) {
            throw new RuntimeException("Error filtering fields: " + e.getMessage(), e);
        }
    }
}
