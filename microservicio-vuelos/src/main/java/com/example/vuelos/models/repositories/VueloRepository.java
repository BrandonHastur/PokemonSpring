package com.example.vuelos.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.commons.models.entities.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long>{

}

