package com.example.vuelos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.commons.models.entities.Aeropuerto;


@FeignClient(name ="microservicio-aeropuertos")
public interface AeropuertoClient {
	
	@GetMapping("/{id}")
	public Aeropuerto getAeropuertoById(@PathVariable Long id);
	
}
