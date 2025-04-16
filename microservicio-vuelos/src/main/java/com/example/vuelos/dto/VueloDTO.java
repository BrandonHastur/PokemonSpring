package com.example.vuelos.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class VueloDTO {

	private Long id;

	@NotNull(message = "El código del vuelo no puede ser nulo")
	private String codigoVuelo;

	@NotNull(message = "El id del avión no puede ser nulo")
	private Long idAvion;

	@NotNull(message = "El id del origen no puede ser nulo")
	private Long idOrigen;

	@NotNull(message = "El id del destino no puede ser nulo")
	private Long idDestino;

	@Future(message = "La fecha de saluda debe ser posterior a la fecha actual")
	private LocalDate fechaSalida;

	@Min(value=1, message = "El Estatus no puede ser menor a 1")
	@Max(value=2, message = "El Estatus no puede ser mayor a 2")
	private long estatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoVuelo() {
		return codigoVuelo;
	}

	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}

	public Long getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(Long idAvion) {
		this.idAvion = idAvion;
	}

	public Long getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(Long idOrigen) {
		this.idOrigen = idOrigen;
	}

	public Long getIdDestino() {
		return idDestino;
	}

	public void setIdDestino(Long idDestino) {
		this.idDestino = idDestino;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public long getEstatus() {
		return estatus;
	}

	public void setEstatus(long estatus) {
		this.estatus = estatus;
	}
}
