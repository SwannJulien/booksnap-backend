package net.booksnap.book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.booksnap.author.Author;
import net.booksnap.cover.Cover;
import net.booksnap.dewey.DeweyCategory;
import net.booksnap.genre.Genre;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"genres", "authors", "covers"})
@ToString(exclude = {"genres", "authors", "covers"})
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
    @JoinColumn(name = "code_dewey")
    private DeweyCategory deweyCategory;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cover> covers = new HashSet<>();
}
