package net.booksnap.dewey;

import org.springframework.stereotype.Component;

@Component
public class DeweyMapper {
    public Dewey fromCode(String code) {
        if (code == null || code.isBlank()) {
            return null;
        }
        Dewey dewey = new Dewey();
        dewey.setCodeDewey(code);
        return dewey;
    }

    public String toCode(Dewey dewey) {
        return (dewey != null) ? dewey.getCodeDewey() : null;
    }
}
