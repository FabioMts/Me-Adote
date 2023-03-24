package com.api.MeAdote.domain.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Especie {

    GATO("gato"),
    CACHORRO("cachorro");

    private String petCode;

    private Especie(String petCode) {
        this.petCode = petCode;
    }

    public String getPetCode() {
        return this.petCode;
    }


    @JsonCreator
    public static Especie getEspecieFromCode(String value) {

        for (Especie pet : Especie.values()) {

            if (pet.getPetCode().equals(value)) {

                return pet;
            }
        }

        return null;
    }

}
