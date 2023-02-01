package com.tutorial.crud.dto;

import javax.validation.constraints.NotBlank;
public class EspeciesDto {
    @NotBlank
    private String nombreEspecie;


    public EspeciesDto() {
    }

    public EspeciesDto(@NotBlank String nombreEspecie) {

        this.nombreEspecie = nombreEspecie;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }
}
