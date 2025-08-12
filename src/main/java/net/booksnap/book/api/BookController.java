package net.booksnap.book.api;

import net.booksnap.book.api.dto.CreateBookRequest;
import net.booksnap.book.mapper.BookApiMapper;
import net.booksnap.book.service.dto.BookBusinessDTO;
import net.booksnap.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


@RestController
@Validated
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookApiMapper apiMapper;

    public BookController(BookService bookService, BookApiMapper apiMapper) {
        this.bookService = bookService;
        this.apiMapper = apiMapper;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addNewBook(@RequestBody @Valid CreateBookRequest request) {
        BookBusinessDTO businessDTO = apiMapper.createRequestToBusinessDTO(request);
        bookService.addBook(businessDTO);
    }

    @GetMapping("/{bookId}")
    public Object getBook(@PathVariable Long bookId,
                          @RequestParam(required = false) String fields) {
        if (fields == null || fields.trim().isEmpty()) {
            BookBusinessDTO businessDTO = bookService.findById(bookId);
            return apiMapper.businessDTOToResponse(businessDTO);
        }
        // Keep existing field filtering for backward compatibility
        return bookService.findByIdWithFields(bookId, fields);
    }
}
