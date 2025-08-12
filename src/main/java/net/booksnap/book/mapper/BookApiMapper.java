package net.booksnap.book.mapper;

import net.booksnap.book.api.dto.CreateBookRequest;
import net.booksnap.book.api.dto.BookResponse;
import net.booksnap.book.service.dto.BookBusinessDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookApiMapper {

    // Convert API request to business DTO
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    BookBusinessDTO createRequestToBusinessDTO(CreateBookRequest request);

    // Convert business DTO to API response
    BookResponse businessDTOToResponse(BookBusinessDTO businessDTO);
}