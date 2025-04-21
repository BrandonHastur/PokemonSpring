package com.example.vuelos.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.commons.CommonMapper;
import com.example.commons.models.entities.Aeropuerto;
import com.example.commons.models.entities.Avion;
import com.example.commons.models.entities.Vuelo;
import com.example.vuelos.clients.AeropuertoClient;
import com.example.vuelos.clients.AvionClient;
import com.example.vuelos.dto.VueloDTO;
import com.example.vuelos.models.repositories.VueloRepository;

@Component
public class VuelosMapper extends CommonMapper<VueloDTO, Vuelo, VueloRepository>{
	
	@Autowired
	private AvionClient avionClient;
	
	@Autowired
	private AeropuertoClient aeropuertoClient;
	
	@Override
	public VueloDTO entityToDto(Vuelo entity) {
		VueloDTO dto = new VueloDTO();
		dto.setId(entity.getId());
		dto.setCodigoVuelo(entity.getCodigoVuelo());
		dto.setIdAvion(entity.getAvion().getId());
		dto.setIdOrigen(entity.getOrigen().getId());
		dto.setIdDestino(entity.getDestino().getId());
		dto.setEstatus(entity.getEstatus());
		dto.setFechaSalida(entity.getFechaSalida());
		return dto;
	}

	
	@Override
	public Vuelo dtoToEntity(VueloDTO dto) {
	    Vuelo entity = new Vuelo();

	    if (dto.getId() != null) {
	        entity.setId(dto.getId());
	    }

	    entity.setCodigoVuelo(dto.getCodigoVuelo());

	    Avion avion = avionClient.getAvionById(dto.getIdAvion());
	    if (avion != null) {
	        entity.setAvion(avion);
	    }

	    Aeropuerto origen = aeropuertoClient.getAeropuertoById(dto.getIdOrigen());
	    if (origen != null) {
	        entity.setOrigen(origen);
	    }

	    Aeropuerto destino = aeropuertoClient.getAeropuertoById(dto.getIdDestino());
	    if (destino != null) {
	        entity.setDestino(destino);
	    }

	    entity.setEstatus(dto.getEstatus());
	    entity.setFechaSalida(dto.getFechaSalida());

	    return entity;
	}
}
