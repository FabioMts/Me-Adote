package com.api.MeAdote.domain.model.enums.Converter;

import com.api.MeAdote.domain.model.enums.FaixaEtaria;

import java.beans.PropertyEditorSupport;

public class faixaEtariaConverterStringToEnum extends PropertyEditorSupport {


    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(FaixaEtaria.getFaixaEtariaFromCode(text));
    }

}
