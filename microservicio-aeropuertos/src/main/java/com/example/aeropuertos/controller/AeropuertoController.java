package com.example.aeropuertos.controller;

import com.example.aeropuertos.dto.AeropuertoDTO;
import org.springframework.web.bind.annotation.RestController;

import com.example.aeropuertos.dto.AeropuertoDTO;
import com.example.aeropuertos.models.services.AeropuertoService;
import com.example.commons.controllers.CommonController;

@RestController
//@RequestMapping("/api/v1/aeropuertos")
public class AeropuertoController extends CommonController<AeropuertoDTO, AeropuertoService>{

	public AeropuertoController(AeropuertoService service) {
		super(service);
	}

}

