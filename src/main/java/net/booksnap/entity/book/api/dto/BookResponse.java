package net.booksnap.entity.book.api.dto;
import net.booksnap.common.dto.AuditDTO;
import net.booksnap.entity.cover.CoverDTO;

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
                           CoverDTO cover,
                           AuditDTO audit ) {}