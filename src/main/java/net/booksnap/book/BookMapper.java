package net.booksnap.book;

import net.booksnap.dewey.DeweyMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = DeweyMapper.class)
public interface BookMapper {

    @Mapping(target = "genres", ignore = true)
    BookDTO bookToBookDto(Book book);

    @Mapping(source = "codeDewey", target = "deweyCategory")
    @Mapping(target = "genres", ignore = true)
    Book bookDtoToBook(BookDTO bookDTO);

}
