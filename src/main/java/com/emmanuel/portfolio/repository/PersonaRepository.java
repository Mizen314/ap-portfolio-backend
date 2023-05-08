package com.emmanuel.portfolio.repository;

import com.emmanuel.portfolio.model.Persona;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona,Integer> {
	}

