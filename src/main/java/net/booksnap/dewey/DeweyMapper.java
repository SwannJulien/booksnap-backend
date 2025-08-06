package net.booksnap.dewey;

import net.booksnap.exception.dewey.DeweyCodeNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DeweyMapper {

    private final DeweyCategoryRepository deweyCategoryRepository;

    public DeweyMapper(DeweyCategoryRepository deweyCategoryRepository) {
        this.deweyCategoryRepository = deweyCategoryRepository;
    }

    public DeweyCategory fromCode(String code) {
        if (code == null || code.isBlank()) {
            return null;
        }

        return deweyCategoryRepository.findByCode(code)
                .orElseThrow(() -> new DeweyCodeNotFoundException(code));
    }

    public String toCode(DeweyCategory deweyCategory) {
        return (deweyCategory != null) ? deweyCategory.getCode() : null;
    }
}
