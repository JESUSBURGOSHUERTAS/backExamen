package com.tutorial.crud.entity;
import javax.persistence.*;
@Entity
@Table(name = "Razas")
public class Razas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idraza;
    private String nombreRaza;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Especies especies;

    // Constructor sin argumentos

    public Razas() {
    }

    public Razas(String nombreRaza, Especies especies) {
        this.nombreRaza = nombreRaza;
        this.especies = especies;
    }

    public int getIdraza() {
        return idraza;
    }

    public void setIdraza(int idraza) {
        this.idraza = idraza;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public Especies getEspecies() {
        return especies;
    }

    public void setEspecies(Especies especies) {
        this.especies = especies;
    }
}
