package com.api.MeAdote.domain.model.enums.Converter;

import com.api.MeAdote.domain.model.enums.Especie;
import com.api.MeAdote.domain.model.enums.Porte;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class PorteConverter implements AttributeConverter<Porte, String> {

    @Override
    public String convertToDatabaseColumn(Porte porte) {
        if(porte == null) {
            return null;
        }
        return porte.getPorteCode();
    }

    @Override
    public Porte convertToEntityAttribute(String code) {
        if(code == null) {
            return null;
        }
        return Stream.of(Porte.values())
                .filter(c -> c.getPorteCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
