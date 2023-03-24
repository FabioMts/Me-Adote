package com.api.MeAdote.domain.model.enums.Converter;

import com.api.MeAdote.domain.model.enums.Especie;
import com.api.MeAdote.domain.model.enums.Sexo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class SexoConverter implements AttributeConverter<Sexo, String> {

    @Override
    public String convertToDatabaseColumn(Sexo sexo) {
        if(sexo == null) {
            return null;
        }
        return sexo.getSexoCode();
    }

    @Override
    public Sexo convertToEntityAttribute(String code) {
        if(code == null) {
            return null;
        }
        return Stream.of(Sexo.values())
                .filter(c -> c.getSexoCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
