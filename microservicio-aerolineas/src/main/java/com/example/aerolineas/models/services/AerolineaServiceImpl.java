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
		List<AerolineaDTO> lista = new ArrayList<>();
		repository.findAll().forEach(linea->{
			lista.add(mapper.entityToDto(linea));
		});
		return lista;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<AerolineaDTO> obtener(Long id) {
		Optional<Aerolinea> optTipo = repository.findById(id);
		if(optTipo.isPresent()) {
			return Optional.of(mapper.entityToDto(optTipo.get()));
		}
		return Optional.empty();
	}
	@Override
	@Transactional
	public AerolineaDTO insertar(AerolineaDTO dto) {
		Aerolinea aerolinea = mapper.dtoToEntity(dto);
		repository.save(aerolinea);
		return dto;
	}
	@Override
	@Transactional
	public AerolineaDTO editar(AerolineaDTO dto, Long id) {
		Optional<Aerolinea> opt = repository.findById(id);
		if(opt.isPresent()) {
			Aerolinea aerolinea = opt.get();
			aerolinea.setNombre(dto.getNombre());
			aerolinea.setPais(dto.getPais());
			aerolinea.setIata(dto.getNombre());
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
