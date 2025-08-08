package net.booksnap.book;

import net.booksnap.exception.dewey.DeweyCodeNotFoundException;
import net.booksnap.exception.dewey.FictionBookHasDeweyCodeException;
import net.booksnap.genre.Genre;
import net.booksnap.genre.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final GenreRepository genreRepository;

    public BookService(BookRepository bookRepository, BookMapper bookMapper, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.genreRepository = genreRepository;
    }

    public void addBook(BookDTO bookDTO) {
        try {
            Book book = bookMapper.bookDtoToBook(bookDTO);

            mapGenres(bookDTO, book);

            bookRepository.save(book);
        } catch (Exception e) {
            if (e.getMessage().contains("non_fiction_requires_dewey")) {
                throw new FictionBookHasDeweyCodeException();
            } else if (e.getMessage().contains("persistent instance references an unsaved transient instance of 'net.booksnap.dewey.Dewey'")) {
                throw new DeweyCodeNotFoundException(bookDTO.getCodeDewey());
            } else throw e;
        }
    }

    private void mapGenres(BookDTO bookDTO, Book book) {
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


}
