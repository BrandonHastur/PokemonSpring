package com.example.vuelos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EntityScan({"com.example.commons.models.entities"})
@EnableFeignClients
public class MicroservicioVuelosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioVuelosApplication.class, args);
	}

}
