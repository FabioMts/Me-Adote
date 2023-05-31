package com.api.MeAdote.domain.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;

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

        for (Especie pet : values()) {

            if (pet.getPetCode().equalsIgnoreCase(value)) {

                return pet;
            }
        }

        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }

}
