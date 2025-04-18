package com.example.aeropuertos.mappers;

import org.springframework.stereotype.Component;

import com.example.commons.CommonMapper;
import com.example.commons.models.entities.Aeropuerto;
import com.example.aeropuertos.dto.AeropuertoDTO;
import com.example.aeropuertos.models.repositories.AeropuertoRepository;

@Component
public class AeropuertoMapper extends CommonMapper<AeropuertoDTO, Aeropuerto, AeropuertoRepository>{
	
	@Override
	public AeropuertoDTO entityToDto(Aeropuerto entity) {
		AeropuertoDTO dto = new AeropuertoDTO();
		dto.setId(entity.getId());
		dto.setNombre(entity.getNombre());
		dto.setCodigo(entity.getCodigo());
		dto.setLatitud(entity.getLatitud());
		dto.setLongitud(entity.getLongitud());
		dto.setPais(entity.getPais());
		dto.setEstatus(entity.getEstatus());
		return dto;
	}

	@Override
	public Aeropuerto dtoToEntity(AeropuertoDTO dto) {
		Aeropuerto entity = new Aeropuerto();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setCodigo(dto.getCodigo());
		entity.setLatitud(dto.getLatitud());
		entity.setLongitud(dto.getLongitud());
		entity.setPais(dto.getPais());
		entity.setEstatus(dto.getEstatus());
		return entity;
	}
}
