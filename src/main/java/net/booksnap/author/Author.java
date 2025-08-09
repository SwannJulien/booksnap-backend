package net.booksnap.author;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.booksnap.book.Book;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "books")
@ToString(exclude = "books")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();
}
