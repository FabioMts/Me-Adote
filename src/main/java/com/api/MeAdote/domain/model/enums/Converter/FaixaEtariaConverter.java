package com.api.MeAdote.domain.model.enums.Converter;

import com.api.MeAdote.domain.model.enums.Especie;
import com.api.MeAdote.domain.model.enums.FaixaEtaria;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class FaixaEtariaConverter implements AttributeConverter<FaixaEtaria, String> {

    @Override
    public String convertToDatabaseColumn(FaixaEtaria faixaEtaria) {
        if(faixaEtaria == null) {
            return null;
        }
        return faixaEtaria.getFaixaEtariaCode();
    }

    @Override
    public FaixaEtaria convertToEntityAttribute(String code) {
        if(code == null) {
            return null;
        }
        return Stream.of(FaixaEtaria.values())
                .filter(c -> c.getFaixaEtariaCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
