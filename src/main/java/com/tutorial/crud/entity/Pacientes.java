package com.tutorial.crud.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Pacientes")
public class Pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpaciente;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idraza", referencedColumnName = "idraza")
    private Razas razas;

    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Nacimiento", nullable = false)
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "idDueno", referencedColumnName = "idDueno")
    private Dueno dueno;

    public Pacientes() {
    }

    public Pacientes(String nombre, Razas razas, Date fechaNacimiento, Dueno dueno) {
        this.nombre = nombre;
        this.razas = razas;
        this.fechaNacimiento = fechaNacimiento;
        this.dueno = dueno;
    }

    // getters y setters


    public int getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(int idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Razas getRazas() {
        return razas;
    }

    public void setRazas(Razas razas) {
        this.razas = razas;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }
}
