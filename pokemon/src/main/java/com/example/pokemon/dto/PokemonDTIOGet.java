package com.example.pokemon.dto;

import java.util.Set;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PokemonDTOGet {
	
	@NotNull
	private Long id;
	private Set<Long> idTipos;
	
	
	private String nombreEvolucion;


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Long getAtaque() {
		return ataque;
	}


	public void setAtaque(Long ataque) {
		this.ataque = ataque;
	}


	public Long getDefensa() {
		return defensa;
	}


	public void setDefensa(Long defensa) {
		this.defensa = defensa;
	}


	public Long getVelocidad() {
		return velocidad;
	}


	public void setVelocidad(Long velocidad) {
		this.velocidad = velocidad;
	}


	public Set<Long> getIdTipos() {
		return idTipos;
	}


	public void setIdTipos(Set<Long> idTipos) {
		this.idTipos = idTipos;
	}


	public String getNombreEvolucion() {
		return nombreEvolucion;
	}


	public void setNombreEvolucion(String nombreEvolucion) {
		this.nombreEvolucion = nombreEvolucion;
	}
	
	
	
	
	
}
