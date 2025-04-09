package net.booksnap.booksnap.book;
public class BookDTO {

    private Long id;
    private Long isbn10;
    private String title;

    public BookDTO() {}

    public BookDTO(Long id, Long isbn10, String title) {
        this.id = id;
        this.isbn10 = isbn10;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public Long getIsbn10() {
        return isbn10;
    }

    public String getTitle() {
        return title;
    }
}

