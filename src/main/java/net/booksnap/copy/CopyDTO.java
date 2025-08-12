package net.booksnap.copy;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id", "libraryName", "libraryId", "bookTitle", "bookId", "codeIdentification", "status", "createdAt", "updatedAt"})
public class CopyDTO {

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