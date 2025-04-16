package com.example.aviones.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class AvionDTO {

	private Long id;

	@NotNull(message="El número de registro no puede ser nulo")
	private Long numRegistro;

	@NotBlank(message="EL tipo no puede estar en blanco")
	private String tipo;

	@NotBlank(message="El código del modelo no puede estar en blanco")
	private String codigoModelo;

	@Min(value=1, message = "La capacidad no puede ser menor a 1")
	private Long capacidad;

	@Past(message = "La fecha del primer vuelo debe ser anterior a la fecha actual")
	private LocalDate fechaPrimerVuelo;

	@Min(value=1, message = "El Estatus no puede ser menor a 1")
	@Max(value=2, message = "El Estatus no puede ser mayor a 2")
	private Long estatus;

	@NotNull(message="El ID de la aerolinea no puede ser nulo")
	private Long idAerolinea;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(Long numRegistro) {
		this.numRegistro = numRegistro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCodigoModelo() {
		return codigoModelo;
	}

	public void setCodigoModelo(String codigoModelo) {
		this.codigoModelo = codigoModelo;
	}

	public Long getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Long capacidad) {
		this.capacidad = capacidad;
	}

	public LocalDate getFechaPrimerVuelo() {
		return fechaPrimerVuelo;
	}

	public void setFechaPrimerVuelo(LocalDate fechaPrimerVuelo) {
		this.fechaPrimerVuelo = fechaPrimerVuelo;
	}

	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}

	public Long getIdAerolinea() {
		return idAerolinea;
	}

	public void setIdAerolinea(Long idAerolinea) {
		this.idAerolinea = idAerolinea;
	}
}
