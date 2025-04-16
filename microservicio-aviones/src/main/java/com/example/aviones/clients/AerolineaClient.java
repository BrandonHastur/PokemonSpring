package com.example.aviones.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="microservicio-aerolineas")
public interface AerolineaClient {
	
	@GetMapping("/{id}")
	public Aerolinea getAerolineaById(@PathVariable Long id);
}

