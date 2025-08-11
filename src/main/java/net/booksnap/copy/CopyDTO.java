package net.booksnap.copy;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CopyDTO {

    // Response-only fields (ignored in POST requests)
    private Long id;
    private String bookTitle;
    private String libraryName;
    private String codeIdentification;
    private Instant createdAt;
    private Instant updatedAt;

    // Request fields (required for POST)
    @NotNull(message = "Book ID is required")
    private Long bookId;

    @NotNull(message = "Library ID is required")
    private Long libraryId;

    private Status status = Status.available;
}