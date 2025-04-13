package com.example.pokemon.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pokemon.models.entities.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long>{
	
}
