package com.example.aeropuertos.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.aeropuertos.models.services.AeropuertoService;

@RestController
//@RequestMapping("/api/v1/aeropuertos")
public class AeropuertoController extends CommonController<AeropuertoDTO, AeropuertoService>{

	public AeropuertoController(AeropuertoService service) {
		super(service);
	}

}

