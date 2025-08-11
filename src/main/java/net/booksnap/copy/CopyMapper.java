package net.booksnap.copy;

import org.springframework.stereotype.Component;

@Component
public class CopyMapper {

    public CopyDTO copyToDTO(Copy copy) {
        CopyDTO dto = new CopyDTO();
        dto.setId(copy.getId());
        dto.setBookId(copy.getBook().getId());
        dto.setBookTitle(copy.getBook().getTitle());
        dto.setLibraryId(copy.getLibrary().getId());
        dto.setLibraryName(copy.getLibrary().getName());
        dto.setCodeIdentification(copy.getCodeIdentification());
        dto.setStatus(copy.getStatus());
        dto.setCreatedAt(copy.getCreatedAt());
        dto.setUpdatedAt(copy.getUpdatedAt());
        return dto;
    }
}