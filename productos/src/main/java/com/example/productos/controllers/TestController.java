package com.example.productos.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // dar funcion de controlador unicamente
//Rest controler es para JSON
@RequestMapping("/api/v1/test") //asignar la ruta
public class TestController {
	
	@GetMapping //mapea cualquier peticion get y la retorna con el valor de esta->>
	public String HolaGet() {
		return "Hola mundo desde controller";
	}
	
	@GetMapping("/{nombre}") //se coloca asi para que traiga la propiedad y no crashe si dos funciones se llaman igual
	public String HolaMundo(@PathVariable String nombre) {
		return "Hola mundo desde controller "+nombre;
	}
	
	@PostMapping //mapea cualquier peticion get y la retorna con el valor de esta->>
	public String HolaPost() {
		return "Hola mundo desde controller";
	}
	
	@PostMapping("/{nombre}") //funciona con todos los verbos
	public String HolaPost(@PathVariable String nombre) {
		return "Hola mundo desde controller "+nombre;
	}
	
	
	@DeleteMapping //mapea cualquier peticion get y la retorna con el valor de esta->>
	public String HolaDelete() {
		return "Hola mundo desde controller";
	}
	
	
	
}
