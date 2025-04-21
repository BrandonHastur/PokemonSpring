package com.example.aerolineas.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.aerolineas.dto.AerolineaDTO;
import com.example.aerolineas.mappers.AerolineaMapper;
import com.example.aerolineas.models.repositories.AerolineaRepository;
import com.example.commons.models.entities.Aerolinea;
import com.example.commons.services.CommonServiceImpl;


@Service
public class AerolineaServiceImpl extends 
	CommonServiceImpl<AerolineaDTO, Aerolinea, AerolineaMapper, AerolineaRepository>
	implements AerolineaService	{

	
	@Override
	@Transactional(readOnly = true)
	public List<AerolineaDTO> listar() {
		List<AerolineaDTO> lista = new ArrayList<>(); //Crea lista vacía de DTOs
		repository.findAll().forEach(linea->{// Obtiene todas las entidades del repositorio
			lista.add(mapper.entityToDto(linea));// Convierte cada entidad a DTO usando el mapper
		});
		return lista;// Retorna la lista de DTOs
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Optional<AerolineaDTO> obtener(Long id) {
		Optional<Aerolinea> optTipo = repository.findById(id);// Busca la entidad por ID
		if(optTipo.isPresent()) {
			return Optional.of(mapper.entityToDto(optTipo.get()));//Si existe, la convierte a DTO
		}
		return Optional.empty();//Retorna Optional (patrón para manejar posibles valores nulos)
	}
	
	
	
	@Override
	@Transactional
	public AerolineaDTO insertar(AerolineaDTO dto) {
		// Aerolinea aerolinea = mapper.dtoToEntity(dto); //Crea, asigna y Convierte el DTO a entidad
		//repository.save(aerolinea); // Guarda la entidad en la base de datos
		dto.setId(repository.save(mapper.dtoToEntity(dto)).getId());
		return dto;// Retorna el mismo DTO
	}
	
	
	
	@Override
	@Transactional
	public AerolineaDTO editar(AerolineaDTO dto, Long id) {
		Optional<Aerolinea> opt = repository.findById(id);
		if(opt.isPresent()) { //
			Aerolinea aerolinea = opt.get();
			aerolinea.setNombre(dto.getNombre());
			aerolinea.setPais(dto.getPais());
			aerolinea.setIata(dto.getIata());
			aerolinea.setEstatus(dto.getEstatus());
			aerolinea.setFechaFundacion(dto.getFecha());
			repository.save(aerolinea);
			
			return mapper.entityToDto(aerolinea);
		}
		return null;
	}
	
	
	
	@Override
	@Transactional
	public AerolineaDTO eliminar(Long id) {
		Optional<Aerolinea> opt = repository.findById(id);
		if(opt.isPresent()) {
			AerolineaDTO dto = mapper.entityToDto(opt.get());
			repository.deleteById(id);
			return dto;
		}
		return null;
	}
	
}
