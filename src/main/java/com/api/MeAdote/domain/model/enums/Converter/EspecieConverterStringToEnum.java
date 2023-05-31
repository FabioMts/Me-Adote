package com.api.MeAdote.domain.model.enums.Converter;

import com.api.MeAdote.domain.model.enums.Especie;

import java.beans.PropertyEditorSupport;

public class EspecieConverterStringToEnum extends PropertyEditorSupport {


    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(Especie.getEspecieFromCode(text));
    }

}
