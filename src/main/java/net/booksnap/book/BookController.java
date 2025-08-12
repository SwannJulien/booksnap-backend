package net.booksnap.book;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


@RestController
@Validated
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // POST: Add a new book
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewBook(@RequestBody @Valid BookDTO bookDTO) {
        bookService.addBook(bookDTO);
    }

    @GetMapping("/{bookId}")
    public Object getBook(@PathVariable Long bookId,
                          @RequestParam(required = false) String fields) {
        return bookService.findById(bookId, fields);
    }
}
