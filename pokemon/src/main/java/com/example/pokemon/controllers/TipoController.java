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
import com.example.pokemon.dto.TipoDTO;
import com.example.pokemon.mappers.TipoMapper;
import com.example.pokemon.models.entities.Tipo;
import com.example.pokemon.services.IService;

@RestController
@RequestMapping("/api/v1/tipos")
public class TipoController {
	
	@Autowired
	private final IService<TipoDTO> service;
	
	
	public TipoController(IService<TipoDTO> service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<TipoDTO>> getAll(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoDTO> getById(@PathVariable Long id){
		Optional<TipoDTO> opt = service.obtenerPorId(id);
		if(opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
	
	@PostMapping
	public ResponseEntity<TipoDTO> post(@RequestBody TipoDTO tipo){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insertar(tipo));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoDTO> put(@RequestBody TipoDTO tipo, @PathVariable Long id) {
		TipoDTO tipoDb = service.editar(tipo, id);
	    if (tipoDb != null) {
	        return ResponseEntity.ok(tipoDb);
	    }
	    return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<TipoDTO> delete(@PathVariable Long id) {
	    TipoDTO tipoDb = service.eliminar(id);
	    if (tipoDb != null) {
	        return ResponseEntity.ok(tipoDb);
	    }
	    return ResponseEntity.notFound().build();
	}
}
