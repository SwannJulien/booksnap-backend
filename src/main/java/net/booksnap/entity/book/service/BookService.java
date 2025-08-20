package net.booksnap.entity.book.service;

import net.booksnap.entity.book.api.dto.BookResponse;
import net.booksnap.entity.book.api.dto.CreateBookRequest;

public interface BookService {
    void addBook(CreateBookRequest createBookRequest);

    BookResponse findBookById(Long bookId);

    Object findByIdWithFields(Long bookId, String fields);

    void deleteBookById(Long bookId);

    void updateBook(Long bookId, CreateBookRequest request);
}
