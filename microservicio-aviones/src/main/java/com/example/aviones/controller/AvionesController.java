package com.example.aviones.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.aviones.dto.AvionDTO;
import com.example.aviones.models.services.AvionesService;
import com.example.commons.controllers.CommonController;

@RestController
//@RequestMapping("/api/v1/aviones")
public class AvionesController extends CommonController<AvionDTO, AvionesService>{

	public AvionesController(AvionesService service) {
		super(service);
		// TODO Auto-generated constructor stub
	}

}