package net.booksnap.book.api;

import net.booksnap.book.api.dto.CreateBookRequest;
import net.booksnap.book.service.BookService;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping("/{bookId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }
}
