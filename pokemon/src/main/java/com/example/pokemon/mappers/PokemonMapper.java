package com.example.pokemon.mappers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.pokemon.dto.PokemonDTO;
import com.example.pokemon.models.entities.Pokemon;
import com.example.pokemon.models.entities.Tipo;
import com.example.pokemon.models.repositories.PokemonRepository;
import com.example.pokemon.models.repositories.TipoRepository;

public class PokemonMapper {
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
	private PokemonRepository pokemonRepository;
	
	public Pokemon dtoToEntity(PokemonDTO dto) {
		Pokemon pokemon = new Pokemon();
		pokemon.setNombre(dto.getNombre());
		pokemon.setAtaque(dto.getAtaque());
		pokemon.setDefensa(dto.getDefensa());
		pokemon.setVelocidad(dto.getVelocidad());
		Set<Tipo> tipos = new HashSet<>();
		dto.getIdTipos().forEach(tipo ->{
			Optional<Tipo> tipoTemp = tipoRepository.findById(tipo);
			if(tipoTemp.isPresent()) {
				tipos.add(tipoRepository.findById(tipo).get());
			}
		
			
		});
		pokemon.setTipos(tipos);
		Optional<Pokemon> evolucion = pokemonRepository.findById(dto.getIdEvolucion());
		if(evolucion.isPresent()) {
			pokemon.setEvolucion(evolucion.get());
		}
		return pokemon;
	}
	
	public PokemonDTO EntityDTO(Pokemon pokemon) {
		PokemonDTO dto = new PokemonDTO();
		dto.setNombre(pokemon.getNombre());
		dto.setAtaque(pokemon.getAtaque());
		dto.setDefensa(pokemon.getDefensa());
		dto.setVelocidad(pokemon.getVelocidad());
		Set<Long> idTipos = new HashSet<>();
		pokemon.getTipos().forEach(tipo->{
			idTipos.add(tipo.getId());
		});
		Optional<Pokemon> evolucion = pokemonRepository.findById(pokemon.getEvolucion().getId());
		if(evolucion.isPresent()) {
			dto.setIdEvolucion(evolucion.get().getId());
		}
		return dto;
	}
	
}
