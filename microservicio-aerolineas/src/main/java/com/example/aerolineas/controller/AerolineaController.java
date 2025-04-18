package com.example.aerolineas.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.aerolineas.dto.AerolineaDTO;
import com.example.aerolineas.models.services.AerolineaService;
import com.example.commons.controllers.CommonController;

@RestController
//@RequestMapping("/api/v1/aerolineas")
public class AerolineaController extends CommonController<AerolineaDTO, AerolineaService>{

	public AerolineaController(AerolineaService service) {
		super(service);
	}

	
}