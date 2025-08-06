package net.booksnap.book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.booksnap.dewey.DeweyCategory;

import java.time.LocalDateTime;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String isbn10;

    @Column(length = 13)
    private String isbn13;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(name = "publishing_year")
    private Short publishingYear;

    @Column(columnDefinition = "TEXT")
    private String publisher;

    @Column(name = "number_of_pages")
    private Short numberOfPages;

    @Column(name = "year_recommendation")
    private Short yearRecommendation;

    @Column(name = "is_fiction", nullable = false)
    private Boolean isFiction;

    @ManyToOne
    @JoinColumn(name = "code")
    private DeweyCategory deweyCategory;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}
