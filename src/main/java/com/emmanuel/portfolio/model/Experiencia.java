package com.emmanuel.portfolio.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="experiencia_laboral")
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idExp;
    
    LocalDate fechaInicio;
    LocalDate fechaFin;
    String empresa;
    String posicion;
    String funciones;
    
    Integer personaId;

    public Experiencia() {
    }

    public Experiencia(LocalDate fechaInicio, LocalDate fechaFin, String empresa, String posicion, String funciones, Integer personaId) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.empresa = empresa;
        this.posicion = posicion;
        this.funciones = funciones;
        this.personaId = personaId;
    }

    public Integer getIdExp() {
        return idExp;
    }

    public void setIdExp(Integer idExp) {
        this.idExp = idExp;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }
    
    
            
    
    
    
    
    
        
    
}
