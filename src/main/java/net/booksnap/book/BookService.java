package net.booksnap.book;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public String addBook(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        bookRepository.save(book);
        return "Book added successfully.";
    }

    public String updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        book.setTitle(bookDTO.getTitle());
        book.setIsbn10(Long.parseLong(bookDTO.getIsbn()));
        bookRepository.save(book);
        return "Book updated successfully.";
    }

    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "Book deleted successfully.";
    }
}
