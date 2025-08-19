package net.booksnap.exception.book;

import net.booksnap.book.Book;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long bookId) {
        super("Book not found with ID: " + bookId);
    }
}
