package com.api.MeAdote.domain.model.enums.Converter;
import com.api.MeAdote.domain.model.enums.Especie;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class EspecieConverter implements AttributeConverter<Especie, String> {

    @Override
    public String convertToDatabaseColumn(Especie especie) {
        if(especie == null) {
            return null;
        }
        return especie.getPetCode();
    }

    @Override
    public Especie convertToEntityAttribute(String code) {
        if(code == null) {
            return null;
        }
        return Stream.of(Especie.values())
                .filter(c -> c.getPetCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
