package com.example.aerolineas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.example.commons.models.entities"}) //escanear entidades fuera del proyecto (en commons)
public class MicroservicioAerolineasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioAerolineasApplication.class, args);
    }

}
