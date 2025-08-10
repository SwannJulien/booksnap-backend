package net.booksnap.book;

import net.booksnap.copy.Copy;
import net.booksnap.copy.CopyRepository;
import net.booksnap.copy.Status;
import net.booksnap.exception.dewey.DeweyCodeNotFoundException;
import net.booksnap.exception.dewey.FictionBookHasDeweyCodeException;
import net.booksnap.library.Library;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final CopyRepository copyRepository;

    public BookService(BookRepository bookRepository,
                       BookMapper bookMapper,
                       CopyRepository copyRepository) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.copyRepository = copyRepository;
    }

    public void addBook(BookDTO bookDTO) {
        try {
            Book book = bookMapper.bookDtoToBook(bookDTO);
            Book savedBook = bookRepository.save(book);

            Copy copy = new Copy();
            copy.setBook(savedBook);
            copy.setLibrary(new Library(bookDTO.getLibraryId(), null));
            copy.setCodeIdentification("generateCode()");
            copy.setStatus(Status.available);
            copyRepository.save(copy);
        } catch (Exception e) {
            if (e.getMessage().contains("non_fiction_requires_dewey")) {
                throw new FictionBookHasDeweyCodeException();
            } else if (e.getMessage().contains("persistent instance references an unsaved transient instance of 'net.booksnap.dewey.Dewey'")) {
                throw new DeweyCodeNotFoundException(bookDTO.getCodeDewey());
            } else throw e;
        }
    }
}
