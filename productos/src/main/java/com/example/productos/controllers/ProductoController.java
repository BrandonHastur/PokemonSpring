package com.example.productos.controllers;

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

import com.example.productos.models.entities.Producto;
import com.example.productos.services.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	
	public ProductoController(ProductoService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Producto>> getAll(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getById(@PathVariable Long id){
		Optional<Producto> opt = service.obtenerPorId(id);
		if(opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Producto> post(@RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.insertar(producto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Producto> put(@RequestBody Producto producto, @PathVariable Long id) {
	    Producto productoDb = service.editar(producto, id);
	    if (productoDb != null) {
	        return ResponseEntity.ok(productoDb);
	    }
	    return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Producto> delete(@PathVariable Long id) {
	    Producto productoDb = service.eliminar(id);
	    if (productoDb != null) {
	        return ResponseEntity.ok(productoDb);
	    }
	    return ResponseEntity.notFound().build();
	}
	
	
	
	
	
	
}
