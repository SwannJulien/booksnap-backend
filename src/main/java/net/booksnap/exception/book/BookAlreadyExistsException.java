package net.booksnap.exception.book;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String identifier) {
        super("Book already exists with identifier: " + identifier);
    }
}