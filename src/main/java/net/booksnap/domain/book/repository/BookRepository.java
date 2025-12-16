package net.booksnap.domain.book.repository;
import net.booksnap.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn10(String isbn10);
    Optional<Book> findByIsbn13(String isbn13);
    Optional<Book> findByTitleIgnoreCase(String title);
}
