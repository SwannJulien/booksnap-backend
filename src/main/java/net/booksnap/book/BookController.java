package net.booksnap.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET: Retrieve all books
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // POST: Add a new book
    @PostMapping
    public ResponseEntity<String> addNewBook(@RequestBody BookDTO bookDTO) {
        String message = bookService.addBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    // PUT: Update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        String message = bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok(message);
    }

    // DELETE: Delete a book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        String message = bookService.deleteBook(id);
        return ResponseEntity.ok(message);
    }
}
