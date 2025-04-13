package com.example.productos.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // dar funcion de controlador unicamente
//Rest controler es para JSON
@RequestMapping("/api/v2/test") //asignar la ruta
public class textControllerV2 {

	@GetMapping //mapea cualquier peticion get y la retorna con el valor de esta->>
	public String HolaGet() {
		return "Hola mundo desde V2";
	}
	
	@PostMapping //mapea cualquier peticion get y la retorna con el valor de esta->>
	public String HolaPost() {
		return "Hola mundo desde V2";
	}
	@PutMapping //mapea cualquier peticion get y la retorna con el valor de esta->>
	public String HolaPut() {
		return "Hola mundo desde V2";
	}
	
	@DeleteMapping //mapea cualquier peticion get y la retorna con el valor de esta->>
	public String HolaDelete() {
		return "Hola mundo desde V2";
	}
	
	
}
