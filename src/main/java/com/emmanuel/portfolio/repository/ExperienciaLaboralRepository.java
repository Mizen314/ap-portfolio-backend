package com.emmanuel.portfolio.repository;

import com.emmanuel.portfolio.model.Experiencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaLaboralRepository extends JpaRepository <Experiencia,Integer> {
	}

