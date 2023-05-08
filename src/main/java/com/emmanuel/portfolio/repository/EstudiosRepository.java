package com.emmanuel.portfolio.repository;

import com.emmanuel.portfolio.model.Estudio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepository extends JpaRepository <Estudio,Integer> {
	}

