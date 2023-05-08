package com.emmanuel.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tecnologias")
public class Tecnologia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer idTecno;
    
    String nombreTecnologia;    
    Integer personaId;

    public Tecnologia() {
    }

    public Tecnologia(String nombreTecnologia, Integer personaId) {
        this.nombreTecnologia = nombreTecnologia;
        this.personaId = personaId;
    }

    public Integer getIdTecno() {
        return idTecno;
    }

    public void setIdTecno(Integer idTecno) {
        this.idTecno = idTecno;
    }

    public String getNombreTecnologia() {
        return nombreTecnologia;
    }

    public void setNombreTecnologia(String nombreTecnologia) {
        this.nombreTecnologia = nombreTecnologia;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    



}
