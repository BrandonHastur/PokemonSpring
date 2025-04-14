package com.example.pokemon.mappers;

import com.example.pokemon.dto.TipoDTO;
import com.example.pokemon.models.entities.Tipo;

public class TipoMapper {
	public Tipo dtoToEntity(TipoDTO dto) {
		Tipo tipo = new Tipo();
		tipo.setNombre(dto.getNombre());
		return tipo;
	}
	
	public TipoDTO EntityToDTO(Tipo tipo) {
		TipoDTO dto = new TipoDTO();
		dto.setNombre(tipo.getNombre());
		return dto;
	}
	
	
}
