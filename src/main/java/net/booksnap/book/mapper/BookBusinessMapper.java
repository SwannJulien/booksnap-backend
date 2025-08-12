package net.booksnap.book.mapper;

import net.booksnap.author.Author;
import net.booksnap.author.AuthorRepository;
import net.booksnap.book.Book;
import net.booksnap.book.service.dto.BookBusinessDTO;
import net.booksnap.cover.Cover;
import net.booksnap.dewey.DeweyCategory;
import net.booksnap.dewey.DeweyCategoryRepository;
import net.booksnap.exception.dewey.DeweyCodeNotFoundException;
import net.booksnap.genre.Genre;
import net.booksnap.genre.GenreRepository;
import net.booksnap.library.Library;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class BookBusinessMapper {

    @Autowired
    protected GenreRepository genreRepository;
    
    @Autowired
    protected DeweyCategoryRepository deweyCategoryRepository;
    
    @Autowired
    protected AuthorRepository authorRepository;

    // Entity to BusinessDTO mapping
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "coverLink", ignore = true)
    @Mapping(target = "coverName", ignore = true)
    @Mapping(target = "libraryId", ignore = true)
    public abstract BookBusinessDTO entityToBusinessDTO(Book book);

    // BusinessDTO to Entity mapping
    @Mapping(target = "deweyCategory", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "covers", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract Book businessDTOToEntity(BookBusinessDTO businessDTO);

    @AfterMapping
    protected void mapGenresToDTO(@MappingTarget BookBusinessDTO businessDTO, Book book) {
        if(book.getGenres() != null && !book.getGenres().isEmpty()) {
            businessDTO.setGenres(book.getGenres().stream().map(Genre::getName).collect(Collectors.toSet()));
        }
    }

    @AfterMapping
    protected void mapAuthorsToDTO(@MappingTarget BookBusinessDTO businessDTO, Book book) {
        if(book.getAuthors() != null && !book.getAuthors().isEmpty()) {
            businessDTO.setAuthors(book.getAuthors().stream().map(Author::getName).collect(Collectors.toSet()));
        }
    }

    @AfterMapping
    protected void mapCoversToDTO(@MappingTarget BookBusinessDTO businessDTO, Book book) {
        if (book.getCovers() != null && !book.getCovers().isEmpty()) {
            Cover firstCover = book.getCovers().iterator().next();
            businessDTO.setCoverLink(firstCover.getLink());
            businessDTO.setCoverName(firstCover.getSize());
        }
    }

    @AfterMapping
    protected void mapCoversToEntity(@MappingTarget Book book, BookBusinessDTO businessDTO) {
        if (businessDTO.getCoverLink() != null && businessDTO.getCoverName() != null) {
            Set<Cover> covers = new HashSet<>();
            Cover cover = new Cover();
            cover.setSize(businessDTO.getCoverName());
            cover.setLink(businessDTO.getCoverLink());
            cover.setBook(book);
            covers.add(cover);
            book.setCovers(covers);
        }
    }

    @AfterMapping
    protected void mapDeweyCategory(@MappingTarget Book book, BookBusinessDTO businessDTO) {
        String codeDewey = businessDTO.getCodeDewey();

        if (codeDewey == null || codeDewey.isBlank()) {
            book.setDeweyCategory(null);
        } else {
            DeweyCategory category = deweyCategoryRepository.findByCode(codeDewey)
                    .orElseThrow(() -> new DeweyCodeNotFoundException(codeDewey));
            book.setDeweyCategory(category);
        }
    }

    @AfterMapping
    protected void mapGenresToEntity(@MappingTarget Book book, BookBusinessDTO businessDTO) {
        if(businessDTO.getGenres() != null && !businessDTO.getGenres().isEmpty()) {
            Set<Genre> genreEntities = businessDTO.getGenres().stream()
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
    protected void mapAuthorsToEntity(@MappingTarget Book book, BookBusinessDTO businessDTO) {
        if(businessDTO.getAuthors() != null && !businessDTO.getAuthors().isEmpty()) {
            Set<Author> authorEntities = businessDTO.getAuthors().stream()
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