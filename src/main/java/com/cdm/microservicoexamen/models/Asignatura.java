package com.cdm.microservicoexamen.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @JsonIgnoreProperties (value = {"asignaturas"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Asignatura asignatura;

    @JsonIgnoreProperties(value = {"asignatura"}, allowSetters = true)
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "asignatura",
            cascade = CascadeType.ALL
    )
    private List<Asignatura> asignaturas;

    public Asignatura() {
        this.asignaturas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Asignatura getAsignatura() { return asignatura; }

    public void setAsignatura(Asignatura asignatura) { this.asignatura = asignatura; }

    public List<Asignatura> getAsignaturas() { return asignaturas; }

    public void setAsignaturas(List<Asignatura> asignaturas) { this.asignaturas = asignaturas; }
}
