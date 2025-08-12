package net.booksnap.book.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {

    private Long id;

    private String title;

    private String isbn10;

    private String isbn13;

    private String publishingYear;

    private String publisher;

    private int numberOfPages;

    private String yearRecommendation;

    private Boolean isFiction;

    private String codeDewey;

    private Set<String> genres;

    private Set<String> authors;

    private String coverLink;

    private String coverName;

    private Date createdAt;

    private Date updatedAt;
}