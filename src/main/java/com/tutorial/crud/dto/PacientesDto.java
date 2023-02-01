package com.tutorial.crud.dto;

import javax.validation.constraints.NotBlank;

public class PacientesDto {
    private Integer idpaciente;
    @NotBlank
    private String nombre;
    private int edad;

    public PacientesDto() {
    }

    public PacientesDto(Integer idpaciente, @NotBlank String nombre, int edad) {
        this.idpaciente = idpaciente;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
