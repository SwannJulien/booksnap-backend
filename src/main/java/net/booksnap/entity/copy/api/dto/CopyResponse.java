package net.booksnap.entity.copy.api.dto;

import net.booksnap.entity.book.api.dto.BookDTO;
import net.booksnap.common.dto.AuditDTO;
import net.booksnap.entity.library.api.dto.LibraryDTO;

public record CopyResponse (
        Long id,
        LibraryDTO library,
        BookDTO book,
        String codeIdentification,
        String status,
        AuditDTO audit
) {}
