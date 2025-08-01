package net.booksnap.book;

import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDTO toDTO(Book book) {
        return new BookDTO(
                book.getId(),
                String.valueOf(book.getIsbn10()), // Convert number to String
                book.getTitle()
        );
    }

    public Book toEntity(BookDTO bookDTO) {
        return new Book(
                Long.parseLong(bookDTO.getIsbn()), // Convert String to number
                bookDTO.getTitle()
        );
    }
}
