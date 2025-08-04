package net.booksnap.book;

import net.booksnap.dewey.DeweyMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = DeweyMapper.class)
public interface BookMapper {

    BookDTO bookToBookDto(Book book);

    @Mapping(source = "codeDewey", target = "dewey")
    Book bookDtoToBook(BookDTO bookDTO);

}
