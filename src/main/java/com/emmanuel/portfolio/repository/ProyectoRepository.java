package com.emmanuel.portfolio.repository;

import com.emmanuel.portfolio.model.Proyecto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto,Integer> {
	}

