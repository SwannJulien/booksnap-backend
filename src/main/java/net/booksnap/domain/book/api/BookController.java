package net.booksnap.domain.book.api;

import net.booksnap.domain.book.Book;
import net.booksnap.domain.book.api.dto.BookResponse;
import net.booksnap.domain.book.api.dto.CreateBookRequest;
import net.booksnap.domain.book.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


@RestController
@Validated
@RequestMapping("api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewBook(@RequestBody @Valid CreateBookRequest request) {
        bookService.addBook(request);
    }

    @GetMapping("/{bookId}")
    public Object getBook(@PathVariable Long bookId,
                          @RequestParam(required = false) String fields) {
        if (fields == null || fields.trim().isEmpty()) {
            return bookService.findBookById(bookId);
        }
        // Keep existing field filtering for backward compatibility
        return bookService.findByIdWithFields(bookId, fields);
    }

    @GetMapping
    public Page<BookResponse> getBooks(
            @PageableDefault(page = 0, size = 10)
            Pageable pageable) {

        return bookService.findAllBooks(pageable);
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long bookId){
        bookService.deleteBookById(bookId);
    }

    @PutMapping("/{bookId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateBook(@PathVariable Long bookId,
                           @RequestBody @Valid CreateBookRequest request) {
        bookService.updateBook(bookId, request);
    }
}
