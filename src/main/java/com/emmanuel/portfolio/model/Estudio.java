package com.emmanuel.portfolio.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estudios")
public class Estudio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idEstudios;
    
    LocalDate fechaInicio;
    LocalDate fechaFin;
    String institucion;
    String titulo;
    
    Integer personaId;


    public Estudio() {
    }
    

    public Estudio(LocalDate fechaInicio, LocalDate fechaFin, String institucion, String titulo, Integer personaId) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.institucion = institucion;
        this.titulo = titulo;
        this.personaId = personaId;
    }


    public Integer getIdEstudios() {
        return idEstudios;
    }


    public void setIdEstudios(Integer idEstudios) {
        this.idEstudios = idEstudios;
    }


    public LocalDate getFechaInicio() {
        return fechaInicio;
    }


    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    public LocalDate getFechaFin() {
        return fechaFin;
    }


    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }


    public String getInstitucion() {
        return institucion;
    }


    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public Integer getPersonaId() {
        return personaId;
    }


    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    
    
}
