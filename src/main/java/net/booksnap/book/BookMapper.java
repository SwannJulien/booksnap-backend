package net.booksnap.book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "genres", ignore = true)
    BookDTO bookToBookDto(Book book);

    @Mapping(target = "deweyCategory", ignore = true)
    @Mapping(target = "genres", ignore = true)
    Book bookDtoToBook(BookDTO bookDTO);

}
