package net.booksnap.exception.dewey;

public class DeweyCodeNotFoundException extends RuntimeException {
    public DeweyCodeNotFoundException() {
        super("The provided Dewey code does not exist.");
    }
}
