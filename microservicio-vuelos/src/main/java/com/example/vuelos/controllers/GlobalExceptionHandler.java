package com.example.vuelos.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> dataIntegrityViolationException(DataIntegrityViolationException e){
		Throwable cause = e.getRootCause();
		if(cause!=null&&cause.getMessage()!=null) {
			return ResponseEntity.badRequest().body("Error de integridad: "+ cause.getMessage());
		}
		return ResponseEntity.badRequest().body("Error de la integridad de los datos");
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> dataIntegrityViolationException(ConstraintViolationException e){
		return ResponseEntity.badRequest().body("Violación de restricción: "+ e.getMessage());
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> dataIntegrityViolationException(RuntimeException e){
		return ResponseEntity.badRequest().body("Error: "+ e.getMessage());
	}
}
