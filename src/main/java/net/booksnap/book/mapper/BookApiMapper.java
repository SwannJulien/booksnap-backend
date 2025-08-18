package net.booksnap.book.mapper;

import net.booksnap.author.Author;
import net.booksnap.author.AuthorRepository;
import net.booksnap.book.Book;
import net.booksnap.book.api.dto.CreateBookRequest;
import net.booksnap.book.api.dto.BookResponse;
import net.booksnap.cover.Cover;
import net.booksnap.dewey.DeweyCategory;
import net.booksnap.dewey.DeweyCategoryRepository;
import net.booksnap.exception.dewey.DeweyCodeNotFoundException;
import net.booksnap.genre.Genre;
import net.booksnap.genre.GenreRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class BookApiMapper {

    @Autowired
    protected GenreRepository genreRepository;

    @Autowired
    protected DeweyCategoryRepository deweyCategoryRepository;

    @Autowired
    protected AuthorRepository authorRepository;

    // Convert API request to Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "covers", ignore = true)
    @Mapping(target = "deweyCategory", ignore = true)
    public abstract Book createRequestToBookEntity(CreateBookRequest request);

    @AfterMapping
    protected void mapGenresToEntity(@MappingTarget Book book, CreateBookRequest request) {
        if(request.genres() != null && !request.genres().isEmpty()) {
            Set<Genre> genreEntities = request.genres().stream()
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
    protected void mapAuthorsToEntity(@MappingTarget Book book, CreateBookRequest request) {
        if(request.authors() != null && !request.authors().isEmpty()) {
            Set<Author> authorEntities = request.authors().stream()
                    .map(name -> {
                        String normalized = name.trim().toLowerCase();
                        return authorRepository.findByName(normalized)
                                .orElseGet(() -> authorRepository.save(new Author(null, normalized, new HashSet<>())));
                    })
                    .collect(Collectors.toSet());

            book.setAuthors(authorEntities);
        }
    }

    @AfterMapping
    protected void mapCoversToEntity(@MappingTarget Book book, CreateBookRequest request) {
        if (request.coverLink() != null && request.coverName() != null) {
            Set<Cover> covers = new HashSet<>();
            Cover cover = new Cover();
            cover.setSize(request.coverName());
            cover.setLink(request.coverLink());
            cover.setBook(book);
            covers.add(cover);
            book.setCovers(covers);
        }
    }

    @AfterMapping
    protected void mapDeweyCategory(@MappingTarget Book book, CreateBookRequest request) {
        String codeDewey = request.codeDewey();

        if (codeDewey == null || codeDewey.isBlank()) {
            book.setDeweyCategory(null);
        } else {
            DeweyCategory category = deweyCategoryRepository.findByCode(codeDewey)
                    .orElseThrow(() -> new DeweyCodeNotFoundException(codeDewey));
            book.setDeweyCategory(category);
        }
    }

    // Convert entity response to DTO
    @Mapping(target = "genres", expression = "java(mapGenresToSet(book.getGenres()))")
    @Mapping(target = "authors", expression = "java(mapAuthorsToSet(book.getAuthors()))")
    @Mapping(target = "coverLink", expression = "java(mapCoverLink(book.getCovers()))")
    @Mapping(target = "coverName", expression = "java(mapCoverName(book.getCovers()))")
    @Mapping(target = "codeDewey", expression = "java(mapDeweyCode(book.getDeweyCategory()))")
    public abstract BookResponse bookEntityToBookResponse(Book book);

    protected Set<String> mapGenresToSet(Set<Genre> genres) {
        if (genres == null || genres.isEmpty()) {
            return null;
        }
        return genres.stream().map(Genre::getName).collect(Collectors.toSet());
    }

    protected Set<String> mapAuthorsToSet(Set<Author> authors) {
        if (authors == null || authors.isEmpty()) {
            return null;
        }
        return authors.stream().map(Author::getName).collect(Collectors.toSet());
    }

    protected String mapCoverLink(Set<Cover> covers) {
        if (covers == null || covers.isEmpty()) {
            return null;
        }
        return covers.iterator().next().getLink();
    }

    protected String mapCoverName(Set<Cover> covers) {
        if (covers == null || covers.isEmpty()) {
            return null;
        }
        return covers.iterator().next().getSize();
    }

    protected String mapDeweyCode(DeweyCategory deweyCategory) {
        if (deweyCategory == null) {
            return null;
        }
        return deweyCategory.getCode();
    }




}