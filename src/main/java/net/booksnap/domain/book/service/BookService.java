package net.booksnap.domain.book.service;

import net.booksnap.domain.book.Book;
import net.booksnap.domain.book.api.dto.BookResponse;
import net.booksnap.domain.book.api.dto.CreateBookRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    void addBook(CreateBookRequest createBookRequest);

    BookResponse findBookById(Long bookId);

    Object findByIdWithFields(Long bookId, String fields);

    void deleteBookById(Long bookId);

    void updateBook(Long bookId, CreateBookRequest request);

    Page<BookResponse> findAllBooks(Pageable pageable);
}
