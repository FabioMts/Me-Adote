package com.api.MeAdote.domain.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Porte {

    PEQUENO("pequeno"),
    MEDIO("medio"),
    GRANDE("grande");


    private String porteCode;

    private Porte(String porteCode) {
        this.porteCode = porteCode;
    }

    public String getPorteCode() {
        return this.porteCode;
    }


    @JsonCreator
    public static Porte getPorteFromCode(String value) {

        for (Porte code : Porte.values()) {

            if (code.getPorteCode().equals(value)) {

                return code;
            }
        }

        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }

}
