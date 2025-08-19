package net.booksnap.book.service;

import net.booksnap.book.api.dto.BookResponse;
import net.booksnap.book.api.dto.CreateBookRequest;

public interface BookService {
    void addBook(CreateBookRequest createBookRequest);

    BookResponse findBookById(Long bookId);

    Object findByIdWithFields(Long bookId, String fields);

    void deleteBookById(Long bookId);
}
