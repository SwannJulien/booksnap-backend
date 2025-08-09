package net.booksnap.book;

import net.booksnap.author.Author;
import net.booksnap.author.AuthorRepository;
import net.booksnap.cover.Cover;
import net.booksnap.dewey.DeweyCategory;
import net.booksnap.dewey.DeweyCategoryRepository;
import net.booksnap.exception.dewey.DeweyCodeNotFoundException;
import net.booksnap.genre.Genre;
import net.booksnap.genre.GenreRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class BookMapper {

    @Autowired
    protected GenreRepository genreRepository;

    @Autowired
    protected DeweyCategoryRepository deweyCategoryRepository;

    @Autowired
    protected AuthorRepository authorRepository;

    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "coverLink", ignore = true)
    @Mapping(target = "coverName", ignore = true)
    public abstract BookDTO bookToBookDto(Book book);

    @Mapping(target = "deweyCategory", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "covers", ignore = true)
    public abstract Book bookDtoToBook(BookDTO bookDTO);

    @AfterMapping
    protected void mapCovers(@MappingTarget Book book, BookDTO bookDTO) {
        if (bookDTO.getCoverLink() != null && bookDTO.getCoverName() != null) {
            Set<Cover> covers = new HashSet<>();
            Cover cover = new Cover();
            cover.setSize(bookDTO.getCoverName());
            cover.setLink(bookDTO.getCoverLink());
            cover.setBook(book);
            covers.add(cover);
            book.setCovers(covers);
        }
    }

    @AfterMapping
    protected void mapCoverFields(@MappingTarget BookDTO bookDTO, Book book) {
        if (book.getCovers() != null && !book.getCovers().isEmpty()) {
            Cover firstCover = book.getCovers().iterator().next();
            bookDTO.setCoverLink(firstCover.getLink());
            bookDTO.setCoverName(firstCover.getSize());
        }
    }

    @AfterMapping
    protected void mapDeweyCategory(@MappingTarget Book book, BookDTO bookDTO) {
        String codeDewey = bookDTO.getCodeDewey();

        if (codeDewey == null || codeDewey.isBlank()) {
            book.setDeweyCategory(null);
        } else {
            DeweyCategory category = deweyCategoryRepository.findByCode(codeDewey)
                    .orElseThrow(() -> new DeweyCodeNotFoundException(codeDewey));
            book.setDeweyCategory(category);
        }
    }

    @AfterMapping
    protected void mapGenres(@MappingTarget Book book, BookDTO bookDTO) {
        if(bookDTO.getGenres() != null && !bookDTO.getGenres().isEmpty()) {
            Set<Genre> genreEntities = bookDTO.getGenres().stream()
                    .map(name -> {
                        String normalized = name.trim().toLowerCase();
                        return genreRepository.findByName(normalized)
                                .orElseGet(() -> genreRepository.save(new Genre(null, normalized, new HashSet<>())));
                    })
                    .collect(Collectors.toSet());

            book.setGenres(genreEntities);
        }
    }

    @AfterMapping
    protected void mapAuthors(@MappingTarget Book book, BookDTO bookDTO) {
        if(bookDTO.getAuthors() != null && !bookDTO.getAuthors().isEmpty()) {
            Set<Author> authorEntities = bookDTO.getAuthors().stream()
                    .map(name -> {
                        String normalized = name.trim().toLowerCase();
                        return authorRepository.findByName(normalized)
                                .orElseGet(() -> authorRepository.save(new Author(null, normalized, new HashSet<>())));
                    })
                    .collect(Collectors.toSet());

            book.setAuthors(authorEntities);
        }
    }
}
