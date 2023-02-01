package com.tutorial.crud.dto;

import javax.validation.constraints.NotBlank;

public class RazasDto {
    @NotBlank
    private String nombreRaza;
    private Integer id;

    public RazasDto() {
    }

    public RazasDto(@NotBlank String nombreRaza, Integer id) {

        this.nombreRaza = nombreRaza;
        this.id=id;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
