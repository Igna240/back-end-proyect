package com.dh.clase36.integradora.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column
    private String email;
    @Column
    private Integer dni;
    @Column
    private LocalDate fechaIngreso;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JsonIgnore
    @JoinColumn(name = "domicilio_id",referencedColumnName = "id")
    private com.dh.clase36.integradora.entities.Domicilio domicilio;

    @OneToMany(mappedBy = "paciente",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<com.dh.clase36.integradora.entities.Turno> turnos=new HashSet<>();
    public Paciente(){

    }

    public Paciente(String apellido, String nombre, String email, Integer dni, LocalDate fechaIngreso, com.dh.clase36.integradora.entities.Domicilio domicilio) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public com.dh.clase36.integradora.entities.Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(com.dh.clase36.integradora.entities.Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Set<com.dh.clase36.integradora.entities.Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<com.dh.clase36.integradora.entities.Turno> turnos) {
        this.turnos = turnos;
    }
}
