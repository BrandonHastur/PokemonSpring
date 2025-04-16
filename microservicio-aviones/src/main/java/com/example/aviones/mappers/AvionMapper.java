package com.example.aviones.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.aviones.clients.AerolineaClient;
import com.example.aviones.dto.AvionDTO;
import com.example.commons.CommonMapper;
import com.example.commons.models.entities.Aerolinea;
import com.example.commons.models.entities.Avion;

@Component
public class AvionMapper extends CommonMapper<AvionDTO, Avion, AvionRepository>{
	
	@Autowired
	private AerolineaClient client;
	
	@Override
	public AvionDTO entityToDto(Avion entity) {
		AvionDTO dto = new AvionDTO();
		dto.setId(entity.getId());
		dto.setNumRegistro(entity.getNumRegistro());
		dto.setTipo(entity.getTipo());
		dto.setCodigoModelo(entity.getCodigoModelo());
		dto.setCapacidad(entity.getCapacidad());
		dto.setFechaPrimerVuelo(entity.getFechaPrimerVuelo());
		dto.setEstatus(entity.getEstatus());
		dto.setIdAerolinea(entity.getAerolinea().getId());
		return dto;
	}

	@Override
	public AvionDTO dtoToEntity(AvionDTO dto) {
		Avion entity = new Avion();
		entity.setId(dto.getId());
		entity.setNumRegistro(dto.getNumRegistro());
		entity.setTipo(dto.getTipo());
		entity.setCodigoModelo(dto.getCodigoModelo());
		entity.setCapacidad(dto.getCapacidad());
		entity.setFechaPrimerVuelo(dto.getFechaPrimerVuelo());
		entity.setEstatus(dto.getEstatus());
		Aerolinea aerolinea = client.getAerolineaById(dto.getIdAerolinea());
		if(aerolinea!=null) {
			entity.setAerolinea(aerolinea);
		}
		return entity;
	}
}
