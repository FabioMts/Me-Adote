package com.api.MeAdote.domain.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Sexo {

    MACHO("macho"),
    FEMEA("femea");

    private String sexoCode;

    private Sexo(String sexoCode) {
        this.sexoCode = sexoCode;
    }

    public String getSexoCode() {
        return this.sexoCode;
    }


    @JsonCreator
    public static Sexo getSexoFromCode(String value) {

        for (Sexo code : Sexo.values()) {

            if (code.getSexoCode().equals(value)) {

                return code;
            }
        }

        return null;
    }
}
