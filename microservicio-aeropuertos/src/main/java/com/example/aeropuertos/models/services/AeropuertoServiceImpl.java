package com.example.aeropuertos.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.aeropuertos.dto.AeropuertoDTO;
import com.example.aeropuertos.mappers.AeropuertoMapper;
import com.example.aeropuertos.models.repositories.AeropuertoRepository;
import com.example.commons.models.entities.Aeropuerto;
import com.example.commons.services.CommonServiceImpl;

@Service
public class AeropuertoServiceImpl extends 
CommonServiceImpl<AeropuertoDTO, Aeropuerto, AeropuertoMapper, AeropuertoRepository>
implements AeropuertoService{

	@Override
	@Transactional(readOnly = true)
	public List<AeropuertoDTO> listar() {
		List<AeropuertoDTO> lista = new ArrayList<>();
		repository.findAll().forEach(linea->{
			lista.add(mapper.entityToDto(linea));
		});
		return lista;
	}

	
	@Override
	@Transactional(readOnly = true)
	public Optional<AeropuertoDTO> obtener(Long id) {
		Optional<Aeropuerto> optTipo = repository.findById(id);
		if(optTipo.isPresent()) {
			return Optional.of(mapper.entityToDto(optTipo.get()));
		}
		return Optional.empty();
	}
	
	
	@Override
	@Transactional
	public AeropuertoDTO insertar(AeropuertoDTO dto) {
	    Aeropuerto nuevo = mapper.dtoToEntity(dto);
	    nuevo.setId(null); // Forzamos a que no tenga ID para que lo genere la secuencia
	    Aeropuerto guardado = repository.save(nuevo);
	    return mapper.entityToDto(guardado);
	}

	@Override
	@Transactional
	public AeropuertoDTO editar(AeropuertoDTO dto, Long id) {
		Optional<Aeropuerto> opt = repository.findById(id);
		if(opt.isPresent()) {
			Aeropuerto aeropuerto = opt.get();
			aeropuerto.setId(dto.getId());
			aeropuerto.setNombre(dto.getNombre());
			aeropuerto.setCodigo(dto.getCodigo());
			aeropuerto.setLatitud(dto.getLatitud());
			aeropuerto.setLongitud(dto.getLongitud());
			aeropuerto.setPais(dto.getPais());
			aeropuerto.setEstatus(dto.getEstatus());
			repository.save(aeropuerto);
			return mapper.entityToDto(aeropuerto);
		}
		return null;
	}
	
	
	@Override
	@Transactional
	public AeropuertoDTO eliminar(Long id) {
		Optional<Aeropuerto> opt = repository.findById(id);
		if(opt.isPresent()) {
			AeropuertoDTO dto = mapper.entityToDto(opt.get());
			repository.deleteById(id);
			return dto;
		}
		return null;
	}

}
