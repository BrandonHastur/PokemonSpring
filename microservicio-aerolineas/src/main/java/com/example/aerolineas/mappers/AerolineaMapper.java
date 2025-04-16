package com.example.aerolineas.mappers;

import org.springframework.stereotype.Component;

import com.example.aerolineas.dto.AerolineaDTO;
import com.example.aerolineas.models.repositories.AerolineaRepository;
import com.example.commons.CommonMapper;
import com.example.commons.models.entities.Aerolinea;


@Component
public class AerolineaMapper extends CommonMapper<AerolineaDTO, Aerolinea, AerolineaRepository>{

	@Override
	public AerolineaDTO entityToDto(Aerolinea entity) {
		AerolineaDTO dto = new AerolineaDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setIata(entity.getIata());
		dto.setPais(entity.getPais());
		dto.setEstatus(entity.getEstatus());
		dto.setFecha(entity.getFechaFundacion());
		return dto;
	}

	@Override
	public Aerolinea dtoToEntity(AerolineaDTO dto) {
		Aerolinea entity = new Aerolinea();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setIata(dto.getIata());
		entity.setPais(dto.getPais());
		entity.setEstatus(dto.getEstatus());
		entity.setFechaFundacion(dto.getFecha());
		return entity;
	}
	
}
