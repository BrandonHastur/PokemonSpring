package com.example.aerolineas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan({"com.example.commons.models.entities"})
public class MicroservicioAerolineasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioAerolineasApplication.class, args);
	}

}
