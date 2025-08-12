package net.booksnap.book;

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
    private final BookMapper bookMapper;
    private final CopyRepository copyRepository;
    private final QRCodeService qrCodeService;
    private final Utils utils;

    public BookService(BookRepository bookRepository,
                       BookMapper bookMapper,
                       CopyRepository copyRepository,
                       QRCodeService qrCodeService,
                       Utils utils) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.copyRepository = copyRepository;
        this.qrCodeService = qrCodeService;
        this.utils = utils;
    }

    public void addBook(BookDTO bookDTO) {
        try {
            Book book = bookMapper.bookDtoToBook(bookDTO);
            Book savedBook = bookRepository.save(book);

            Copy copy = new Copy();
            copy.setBook(savedBook);
            copy.setLibrary(new Library(bookDTO.getLibraryId(), null));
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
                throw new DeweyCodeNotFoundException(bookDTO.getCodeDewey());
            } else throw e;
        }
    }

    public Object findById(Long bookId, String fields) {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));
        BookDTO bookDTO = bookMapper.bookToBookDto(book);

        if (fields == null || fields.trim().isEmpty()) {
            return bookDTO;
        }

        try {
            return utils.filterFields(bookDTO, fields);
        } catch (Exception e) {
            throw new RuntimeException("Error filtering fields: " + e.getMessage(), e);
        }
    }
}
