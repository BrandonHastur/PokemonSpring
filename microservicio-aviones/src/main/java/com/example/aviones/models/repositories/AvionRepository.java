package com.example.aviones.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.commons.models.entities.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long>{

}
