package net.booksnap.copy;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CopyMapper {

    @Mapping(target = "bookTitle", source = "book.title")
    @Mapping(target = "bookId", source = "book.id")
    @Mapping(target = "libraryName", source = "library.name")
    @Mapping(target = "libraryId", source = "library.id")
    public abstract CopyDTO copyToDTO(Copy copy);
}