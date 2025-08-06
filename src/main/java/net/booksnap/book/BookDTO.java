package net.booksnap.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private String title;
    private String isbn10;
    private String isbn13;
    private String publishing_year;
    private String publisher;
    private int numberOfPages;
    private String yearRecommendation;
    private Boolean isFiction;
    private String codeDewey;
    private Date createdAt;
    private Date updatedAt;
}

