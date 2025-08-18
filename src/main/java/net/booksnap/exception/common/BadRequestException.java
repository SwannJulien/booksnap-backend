package net.booksnap.exception.common;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super("Bad request: " + message);
    }
}
