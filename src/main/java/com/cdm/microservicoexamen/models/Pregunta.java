package com.cdm.microservicoexamen.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "preguntas")
public class Pregunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPregunta;

    @Column
    private String texto;

    @JsonIgnoreProperties(value = {"preguntas"})
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "examen_id")
    private  Examen examen;

    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Pregunta)){
            return false;
        }

        Pregunta pregunta = (Pregunta) obj;

        return this.idPregunta != null && this.idPregunta.equals(pregunta.getIdPregunta());
    }
}
