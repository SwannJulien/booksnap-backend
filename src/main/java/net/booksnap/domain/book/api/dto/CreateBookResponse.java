package net.booksnap.domain.book.api.dto;

public record CreateBookResponse(
    byte[] qrCode,
    String codeIdentification,
    Long copyId,
    Long bookId
) {}