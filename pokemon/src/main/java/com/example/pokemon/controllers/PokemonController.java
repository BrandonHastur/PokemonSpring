package com.example.pokemon.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokemon.dto.PokemonDTO;
import com.example.pokemon.models.entities.Pokemon;
import com.example.pokemon.services.IService;

@RestController
@RequestMapping("/api/v1/pokemones")
public class PokemonController {
	
		@Autowired
		private final PokemonServiceImpl service;
		
		
		public PokemonController(PokemonServiceImpl service) {
			this.service = service;
		}
		
		@GetMapping
		public ResponseEntity<List<PokemonDTOGet>> getAll(){
			return ResponseEntity.ok(service.listarDTO());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<PokemonDTOGet> getById(@PathVariable Long id){
			Optional<PokemonDTOGet> opt = service.dtoObtenerPorId(id);
			if(opt.isPresent()) {
				return ResponseEntity.ok(opt.get());
			}
			return ResponseEntity.notFound().build();
		}
		
		@PostMapping
		public ResponseEntity<PokemonDTOGet> post(@RequestBody PokemonDTO pokemon){
			return ResponseEntity.status(HttpStatus.CREATED).body(service.insertar(pokemon));
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<PokemonDTO> put(@RequestBody PokemonDTO pokemon, @PathVariable Long id) {
			PokemonDTO pokemonDb = service.editar(pokemon, id);
		    if (pokemonDb != null) {
		        return ResponseEntity.ok(pokemonDb);
		    }
		    return ResponseEntity.notFound().build();
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<PokemonDTO> delete(@PathVariable Long id) {
			PokemonDTO pokemonDb = service.eliminar(id);
		    if (pokemonDb != null) {
		        return ResponseEntity.ok(pokemonDb);
		    }
		    return ResponseEntity.notFound().build();
		}


}
