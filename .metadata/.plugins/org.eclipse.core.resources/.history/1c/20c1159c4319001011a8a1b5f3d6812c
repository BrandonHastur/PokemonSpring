package com.example.pokemon.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.example.pokemon.models.entities.Pokemon;
import com.example.pokemon.models.repositories.PokemonRepository;

public class PokemonServiceImpl implements IService<Pokemon>{
	
	
	@Autowired
	private PokemonRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Pokemon> listar() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly= true)
	public Optional<Pokemon> obtenerPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	public Pokemon insertar(Pokemon entity) {
		return repository.save(entity);
	}

	@Override
	public Pokemon editar(Pokemon entity, Long id) {
		Optional<Pokemon> opt = repository.findById(id);
		if(opt.isPresent()) {
			Pokemon pokemon = opt.get();
			pokemon.setNombre(entity.getNombre());
			pokemon.setAtaque(entity.getAtaque());
			pokemon.setDefensa(entity.getDefensa());
			pokemon.setVelocidad(entity.getVelocidad());
			pokemon.setEvolucion(entity.getEvolucion());
			return repository.save(pokemon);
		}
		return null;
	}

	@Override
	@Transactional
	public Pokemon eliminar(Long id) {
		Optional<Pokemon> opt = repository.findById(id);
		if(opt.isPresent()) {
			repository.deleteById(id);
			return opt.get();
		}
		return null;
	}
	
}
