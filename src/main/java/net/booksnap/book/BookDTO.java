package net.booksnap.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    @NotNull(message = "The book title is required")
    private String title;

    @Size(min = 10, max = 10, message = "Isbn10 must be 10 characters long")
    private String isbn10;

    @Size(min = 13, max = 13, message = "Isbn13 must be 13 characters long")
    private String isbn13;

    private String publishingYear;

    private String publisher;

    private int numberOfPages;

    private String yearRecommendation;

    @NotNull(message = "The book genre fiction/no fiction is required")
    private Boolean isFiction;

    private String codeDewey;

    private Set<String> genres;

    private Set<String> authors;

    private String coverLink;

    private String coverName;

    @NotNull
    private Long libraryId;

    private Date createdAt;

    private Date updatedAt;
}

