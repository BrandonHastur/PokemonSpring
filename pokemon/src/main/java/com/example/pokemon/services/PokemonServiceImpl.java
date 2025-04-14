package com.example.pokemon.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.pokemon.dto.PokemonDTO;
import com.example.pokemon.models.entities.Pokemon;
import com.example.pokemon.models.entities.Tipo;
import com.example.pokemon.models.repositories.PokemonRepository;

public class PokemonServiceImpl implements IService<Pokemon>{
	
	
	@Autowired
	private PokemonRepository repository;
	
	private TipoRepository tipoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<PokemonDTO> listar() {
		List<PokeomnDTO> lista = new ArrayList<>();
		repository.findAll().forEach(Pokemon -> {
			lista.add(mapper.entityToDTO(pokemon));
		});
		return lista;
	}

	@Override
	@Transactional(readOnly= true)
	public Optional<Pokemon> obtenerPorId(Long id) {
		Optional<PokemonDTIO> optional = repository.findById(id);
		if(optional.isPresent()) {
			return Optional.of(mapper.entityToDTO(optional.get()));
		}
		return repository.findById(id);
	}

	@Override
	public PokemonDTO insertar(PokemonDTO entity) {
		repository.save(mapper.dtoToEntity(entity));
		return entity;
	}

	@Override
	public PokemonDTO editar(PokemonDTO entity, Long id) {
		Optional<Pokemon> opt = repository.findById(id);
		if(opt.isPresent()) {
			Pokemon pokemon = opt.get();
			pokemon.setNombre(entity.getNombre());
			pokemon.setAtaque(entity.getAtaque());
			pokemon.setDefensa(entity.getDefensa());
			pokemon.setVelocidad(entity.getVelocidad());
			Set<Tipo> tipos = new HashSet<>();
			entity.getIdTipos().forEach(idTipo ->{
				Optional<Tipo> temporal = tipoRepository.findById(idTipo);
				if(temporal.isPresent()) {
					tipos.add(temporal.get());
				}
			});
			pokemon.setTipos(tipos);
			if(entity.getIdEvolucion()!=null) {
				Optional<Pokemon> evolucion = repository.findById(entity.getIdEvolucion());
				if(evolucion.isPresent()) {
					pokemon.setEvolucion(evolucion.get());
				}
			}
			repository.save(pokemon);
			return entity; 
		}
		return null;
	}

	@Override
	@Transactional
	public PokemonDTO eliminar(Long id) {
		Optional<Pokemon> opt = repository.findById(id);
		if(opt.isPresent()) {
			repository.deleteById(id);
			return mapper.entityToDTO(opt.get());
		}
		return null;
	}
	
	//FOTO
	
}
