package net.booksnap.entity.book.service;

import net.booksnap.entity.book.Book;
import net.booksnap.entity.book.api.dto.BookResponse;
import net.booksnap.entity.book.api.dto.CreateBookRequest;
import net.booksnap.entity.book.mapper.BookApiMapper;
import net.booksnap.entity.book.repository.BookRepository;
import net.booksnap.entity.copy.Copy;
import net.booksnap.entity.copy.repository.CopyRepository;
import net.booksnap.entity.copy.Status;
import net.booksnap.exception.book.BookNotFoundException;
import net.booksnap.exception.common.BadRequestException;
import net.booksnap.exception.dewey.DeweyCodeNotFoundException;
import net.booksnap.exception.dewey.FictionBookHasDeweyCodeException;
import net.booksnap.entity.library.Library;
import net.booksnap.utils.qr.QRCodeService;
import net.booksnap.utils.Utils;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookApiMapper bookApiMapper;
    private final CopyRepository copyRepository;
    private final QRCodeService qrCodeService;
    private final Utils utils;

    public BookServiceImpl(BookRepository bookRepository,
                           BookApiMapper bookApiMapper,
                           CopyRepository copyRepository,
                           QRCodeService qrCodeService,
                           Utils utils) {
        this.bookRepository = bookRepository;
        this.bookApiMapper = bookApiMapper;
        this.copyRepository = copyRepository;
        this.qrCodeService = qrCodeService;
        this.utils = utils;
    }

    public void addBook(CreateBookRequest createBookRequest) {
        try {
            Book book = bookApiMapper.createRequestToBookEntity(createBookRequest);
            Book savedBook = bookRepository.save(book);

            Copy copy = new Copy();
            copy.setBook(savedBook);
            copy.setLibrary(new Library(createBookRequest.libraryId(), null));
            copy.setStatus(Status.available);
            copy.setCodeIdentification("TEMP"); // Temporary placeholder to satisfy @NotNull
            
            Copy savedCopy = copyRepository.save(copy);
            
            // Generate QR code identification after saving to get the ID
            String qrCodeIdentification = qrCodeService.generateCopyIdentificationCode(savedCopy);
            savedCopy.setCodeIdentification(qrCodeIdentification);
            copyRepository.save(savedCopy);
            
        } catch (Exception ex) {
            if (ex.getMessage().contains("non_fiction_requires_dewey")) {
                throw new FictionBookHasDeweyCodeException();
            } else if (ex.getMessage().contains("persistent instance references an unsaved transient instance of 'net.booksnap.entity.dewey.Dewey'")) {
                throw new DeweyCodeNotFoundException(createBookRequest.codeDewey());
            } else throw new BadRequestException(ex.getMessage());
        }
    }

    public BookResponse findBookById(Long bookId) {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new BookNotFoundException(bookId));
        return bookApiMapper.bookEntityToBookResponse(book);
    }

    public Object findByIdWithFields(Long bookId, String fields) {
        BookResponse bookResponse = findBookById(bookId);
        try {
            return utils.filterFields(bookResponse, fields);
        } catch (Exception e) {
            throw new RuntimeException("Error filtering fields: " + e.getMessage(), e);
        }
    }

    public void deleteBookById(Long bookId) {
        if (bookRepository.existsById(bookId)){
            bookRepository.deleteById(bookId);
        } else {
            throw new BookNotFoundException(bookId);
        }
    }
}
