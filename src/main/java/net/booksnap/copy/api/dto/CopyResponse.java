package net.booksnap.copy.api.dto;

import net.booksnap.book.api.dto.BookDTO;
import net.booksnap.common.dto.AuditDTO;
import net.booksnap.library.api.dto.LibraryDTO;

public record CopyResponse (
        Long id,
        LibraryDTO library,
        BookDTO book,
        String codeIdentification,
        String status,
        AuditDTO audit
) {}
