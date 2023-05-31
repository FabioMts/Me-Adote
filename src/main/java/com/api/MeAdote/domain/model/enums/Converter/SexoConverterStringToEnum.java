package com.api.MeAdote.domain.model.enums.Converter;

import com.api.MeAdote.domain.model.enums.Sexo;

import java.beans.PropertyEditorSupport;

public class SexoConverterStringToEnum extends PropertyEditorSupport {


    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(Sexo.getSexoFromCode(text));
    }

}
