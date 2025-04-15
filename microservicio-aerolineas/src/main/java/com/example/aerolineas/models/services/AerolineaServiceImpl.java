package com.example.aerolineas.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.aerolineas.dto.AerolineaDTO;
import com.example.aerolineas.mappers.AerolineaMapper;
import com.example.aerolineas.models.repositories.AerolineaRepository;
import com.example.commons.models.entities.Aerolinea;
import com.example.commons.services.CommonService;
import com.example.commons.services.CommonServiceImpl;

@Service
public class AerolineaServiceImpl extends CommonServiceImpl<AerolineaDTO, Aerolinea,
        AerolineaMapper, AerolineaRepository> implements CommonService<AerolineaDTO> {

    @Override
    public List<AerolineaDTO> listar() {
        List<AerolineaDTO> lista = new ArrayList<AerolineaDTO>();
        repository.findAll().forEach( aerolinea -> {
            lista.add(mapper.entityToDto(aerolinea));
        });
        return super.listar();
    }

    @Override
    public Optional<AerolineaDTO> obtener(Long id) {
        Optional<Aerolinea> opt = repository.findById(id);
        if (opt.isPresent()) {
            return Optional.of(mapper.entityToDto(opt.get()));
        }
        return Optional.empty();
    }

    @Override
    public AerolineaDTO editar(AerolineaDTO entity, Long id) {
        Optional<Aerolinea> opt = repository.findById(id);
        if (opt.isPresent()) {
            Aerolinea aerolinea = opt.get();
            aerolinea.setNombre(entity.getNombre());
            aerolinea.setIata(entity.getIata());
            aerolinea.setPais(entity.getPais());
            aerolinea.setEstatus(entity.getEstatus());
            aerolinea.setFechaFundacion(entity.getFechaFundacion());
            repository.save(aerolinea);
            return mapper.entityToDto(aerolinea);
        }
        return null;
    }

    @Override
    public AerolineaDTO insertar(AerolineaDTO dto) {
            Aerolinea aerolinea = new Aerolinea();
            aerolinea.setNombre(dto.getNombre());
            aerolinea.setIata(dto.getIata());
            aerolinea.setPais(dto.getPais());
            aerolinea.setEstatus(dto.getEstatus());
            aerolinea.setFechaFundacion(dto.getFechaFundacion());
            return this.mapper.entityToDto(this.repository.save(aerolinea));
    }

    @Override
    public AerolineaDTO eliminar(Long id) {
        Optional<Aerolinea> aerolinea = this.repository.findById(id);
        if(aerolinea.isPresent()) {
            this.repository.deleteById(id);
            AerolineaDTO dto = this.mapper.entityToDto(aerolinea.get());
            return dto;
        }
        return null;
    }
}
