package com.api.MeAdote.domain.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FaixaEtaria {

    ADULTO("adulto"),
    JOVEM("jovem"),
    FILHOTE("filhote");

    private String faixaEtariaCode;

    private FaixaEtaria(String faixaEtariaCode) {
        this.faixaEtariaCode = faixaEtariaCode;
    }

    public String getFaixaEtariaCode() {
        return this.faixaEtariaCode;
    }


    @JsonCreator
    public static FaixaEtaria getFaixaEtariaFromCode(String value) {

        for (FaixaEtaria pet : FaixaEtaria.values()) {

            if (pet.getFaixaEtariaCode().equals(value)) {

                return pet;
            }
        }

        return null;
    }
}
