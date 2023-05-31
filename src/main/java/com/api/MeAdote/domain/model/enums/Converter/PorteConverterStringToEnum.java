package com.api.MeAdote.domain.model.enums.Converter;

import com.api.MeAdote.domain.model.enums.Porte;

import java.beans.PropertyEditorSupport;

public class PorteConverterStringToEnum extends PropertyEditorSupport {


    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(Porte.getPorteFromCode(text));
    }

}
