package com.example.vuelos.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.commons.controllers.CommonController;
import com.example.vuelos.dto.VueloDTO;
import com.example.vuelos.models.services.VueloService;

@RestController
//@RequestMapping("/api/v1/vuelos")
public class VueloController extends CommonController<VueloDTO, VueloService>{

	public VueloController(VueloService service) {
		super(service);
	}

}
