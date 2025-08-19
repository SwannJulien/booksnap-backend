package net.booksnap.book.api.dto;
import java.util.Date;
import java.util.Set;


public record BookResponse(Long id,
                           String title,
                           String isbn10,
                           String isbn13,
                           String publishingYear,
                           String publisher,
                           int numberOfPages,
                           String yearRecommendation,
                           Boolean isFiction,
                           String codeDewey,
                           Set<String> genres,
                           Set<String> authors,
                           String coverLink,
                           String coverName,
                           Date createdAt,
                           Date updatedAt) {}