package net.booksnap.entity.copy.mapper;

import net.booksnap.entity.book.api.dto.BookDTO;
import net.booksnap.common.dto.AuditDTO;
import net.booksnap.entity.copy.Copy;
import net.booksnap.entity.copy.api.dto.CopyResponse;
import net.booksnap.entity.copy.Status;
import net.booksnap.entity.copy.api.dto.CreateCopyRequest;
import net.booksnap.entity.library.api.dto.LibraryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Date;

@Mapper(componentModel = "spring")
public abstract class CopyApiMapper {

    @Mapping(target = "library", expression = "java(mapLibrary(copy.getLibrary()))")
    @Mapping(target = "book", expression = "java(mapBook(copy.getBook()))")
    @Mapping(target = "audit", expression = "java(mapAudit(copy.getCreatedAt(), copy.getUpdatedAt()))")
    public abstract CopyResponse copyToResponse(Copy copy);

    protected LibraryDTO mapLibrary(net.booksnap.entity.library.Library library) {
        if (library == null) {
            return null;
        }
        return new LibraryDTO(library.getId(), library.getName());
    }

    protected BookDTO mapBook(net.booksnap.entity.book.Book book) {
        if (book == null) {
            return null;
        }
        return new BookDTO(book.getId(), book.getTitle());
    }

    protected AuditDTO mapAudit(java.time.Instant createdAt, java.time.Instant updatedAt) {
        return new AuditDTO(Date.from(createdAt), Date.from(updatedAt));
    }

    @Mapping(target = "bookTitle", source = "book.title")
    @Mapping(target = "bookId", source = "book.id")
    @Mapping(target = "libraryName", source = "library.name")
    @Mapping(target = "libraryId", source = "library.id")
    public abstract CreateCopyRequest copyToDTO(Copy copy);

    // Convert CreateCopyRequest to Copy entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "library", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "status", expression = "java(mapStatus(request.status()))")
    public abstract Copy createRequestToCopy(CreateCopyRequest request);

    protected Status mapStatus(Status requestStatus) {
        return requestStatus != null ? requestStatus : Status.available;
    }
}