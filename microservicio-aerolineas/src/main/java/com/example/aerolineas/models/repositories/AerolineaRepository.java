package com.example.aerolineas.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.commons.models.entities.Aerolinea;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {
}
