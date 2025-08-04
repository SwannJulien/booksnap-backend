package net.booksnap.book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // POST: Add a new book
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewBook(@RequestBody BookDTO bookDTO) {
        bookService.addBook(bookDTO);
//        return new ResponseEntity<>("Book added successfully.", HttpStatus.CREATED);
    }
}
