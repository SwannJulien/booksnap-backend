package net.booksnap.book;
import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long isbn10;

    private String title;

    public Book() {}

    public Book(Long isbn10, String title) {
        this.isbn10 = isbn10;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public Long getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(Long isbn10) {
        this.isbn10 = isbn10;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
