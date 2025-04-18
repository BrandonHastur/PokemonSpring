package com.example.vuelos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.commons.models.entities.Avion;


@FeignClient(name ="microservicio-aviones")
public interface AvionClient {
	
	@GetMapping("/{id}")
	public Avion getAvionById(@PathVariable Long id);
	
}
