package net.booksnap.book;

import net.booksnap.exception.dewey.DeweyCodeNotFoundException;
import net.booksnap.exception.dewey.FictionBookHasDeweyCodeException;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public void addBook(BookDTO bookDTO) {
        try {
            Book book = bookMapper.bookDtoToBook(bookDTO);
            bookRepository.save(book);
        } catch (Exception e) {
            if (e.getMessage().contains("non_fiction_requires_dewey")) {
                throw new FictionBookHasDeweyCodeException();
            } else if (e.getMessage().contains("persistent instance references an unsaved transient instance of 'net.booksnap.dewey.Dewey'")) {
                throw new DeweyCodeNotFoundException(bookDTO.getCodeDewey());
            } else throw e;
        }
    }
}
