package com.example.aviones.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.aviones.dto.AvionDTO;
import com.example.aviones.mappers.AvionMapper;
import com.example.aviones.models.repositories.AvionRepository;
import com.example.commons.models.entities.Avion;
import com.example.commons.services.CommonServiceImpl;

@Service
public class AvionesServiceImpl extends 
	CommonServiceImpl<AvionDTO, Avion, AvionMapper, AvionRepository>
	implements AvionesService{
	
	@Override
	@Transactional(readOnly = true)
	public List<AvionDTO> listar() {
		List<AvionDTO> lista = new ArrayList<>();
		repository.findAll().forEach(linea->{
			lista.add(mapper.entityToDto(linea));
		});
		return lista;
	}

	
	@Override
	@Transactional(readOnly = true)
	public Optional<AvionDTO> obtener(Long id) {
		Optional<Avion> optTipo = repository.findById(id);
		if(optTipo.isPresent()) {
			return Optional.of(mapper.entityToDto(optTipo.get()));
		}
		return Optional.empty();
	}

	
	@Override
	@Transactional
	public AvionDTO insertar(AvionDTO dto) {
	    Avion nuevo = mapper.dtoToEntity(dto);
	    nuevo.setId(null);
	    Avion guardado = repository.save(nuevo);
	    return mapper.entityToDto(guardado);
	}
	
	
	@Override
	@Transactional
	public AvionDTO editar(AvionDTO dto, Long id) {
		Optional<Avion> opt = repository.findById(id);
		if(opt.isPresent()) {
			dto.setId(id);
			repository.save(mapper.dtoToEntity(dto));
			return dto;
		}
		return null;
	}

	
	@Override
	@Transactional
	public AvionDTO eliminar(Long id) {
		Optional<Avion> opt = repository.findById(id);
		if(opt.isPresent()) {
			AvionDTO dto = mapper.entityToDto(opt.get());
			repository.deleteById(id);
			return dto;
		}
		return null;
	}

}
