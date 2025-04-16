package com.example.aeropuertos.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.aeropuertos.dto.AeropuertoDTO;

@Service
public class AeropuertoServiceImpl extends 
CommonServiceImpl<AeropuertoDTO, Aeropuerto, AeropuertoMapper, AeropuertoRespository>
implements AeropuertoService	{

	@Override
	@Transactional(readOnly = true)
	public List<AeropuertoDTO> listar() {
		List<AeropuertoDTO> lista = new ArrayList<>();
		repository.findAll().forEach(linea->{
			lista.add(mapper.entityToDTO(linea));
		});
		return lista;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<AeropuertoDTO> obtenerPorId(Long id) {
		Optional<Aeropuerto> optTipo = repository.findById(id);
		if(optTipo.isPresent()) {
			return Optional.of(mapper.entityToDTO(optTipo.get()));
		}
		return Optional.empty();
	}
	
	@Override
	@Transactional
	public AeropuertoDTO insertar(AeropuertoDTO dto) {
		Aeropuerto aeropuerto = mapper.dtoToEntity(dto);
		repository.save(aeropuerto);
		return dto;
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
			return mapper.entityToDTO(aeropuerto);
		}
		return null;
	}
	
	@Override
	@Transactional
	public AeropuertoDTO eliminar(Long id) {
		Optional<Aeropuerto> opt = repository.findById(id);
		if(opt.isPresent()) {
			AeropuertoDTO dto = mapper.entityToDTO(opt.get());
			repository.deleteById(id);
			return dto;
		}
		return null;
	}

}
