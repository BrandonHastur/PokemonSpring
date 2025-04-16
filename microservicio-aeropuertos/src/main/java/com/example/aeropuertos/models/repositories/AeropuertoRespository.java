package com.example.aeropuertos.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeropuertoRespository extends JpaRepository<Aeropuerto, Long>{

}

