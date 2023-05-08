package com.emmanuel.portfolio.repository;

import com.emmanuel.portfolio.model.Tecnologia;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnologiasRepository extends JpaRepository <Tecnologia,Integer> {
	}

