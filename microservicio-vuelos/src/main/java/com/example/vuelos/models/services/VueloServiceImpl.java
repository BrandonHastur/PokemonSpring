package com.example.vuelos.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.commons.models.entities.Vuelo;
import com.example.commons.services.CommonServiceImpl;
import com.example.vuelos.dto.VueloDTO;
import com.example.vuelos.mappers.VuelosMapper;
import com.example.vuelos.models.repositories.VueloRepository;

@Service
public class VueloServiceImpl extends 
	CommonServiceImpl<VueloDTO, Vuelo, VuelosMapper, VueloRepository>
	implements VueloService	{

	@Override
	@Transactional(readOnly = true)
	public List<VueloDTO> listar() {
		List<VueloDTO> lista = new ArrayList<>();
		repository.findAll().forEach(linea->{
			lista.add(mapper.entityToDto(linea));
		});
		return lista;
	}

	
	@Override
	@Transactional(readOnly = true)
	public Optional<VueloDTO> obtener(Long id) {
		Optional<Vuelo> optTipo = repository.findById(id);
		if(optTipo.isPresent()) {
			return Optional.of(mapper.entityToDto(optTipo.get()));
		}
		return Optional.empty();
	}
	
	
	@Override
	@Transactional
	public VueloDTO insertar(VueloDTO dto) {
		Vuelo vuelo = mapper.dtoToEntity(dto);
		repository.save(vuelo);
		return dto;
	}
	
	
	@Override
	@Transactional
	public VueloDTO editar(VueloDTO dto, Long id) {
		Optional<Vuelo> opt = repository.findById(id);
		if(opt.isPresent()) {
			dto.setId(id);
			repository.save(mapper.dtoToEntity(dto));
			return dto;
		}
		return null;
	}

	@Override
	@Transactional
	public VueloDTO eliminar(Long id) {
		Optional<Vuelo> opt = repository.findById(id);
		if(opt.isPresent()) {
			VueloDTO dto = mapper.entityToDto(opt.get());
			repository.deleteById(id);
			return dto;
		}
		return null;
	}
	
}
