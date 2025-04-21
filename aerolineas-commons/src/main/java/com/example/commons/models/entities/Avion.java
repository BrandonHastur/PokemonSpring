package com.example.commons.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="AVION")
public class Avion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEO_AVION")
	@SequenceGenerator(name="SEO_AVION", sequenceName = "SEO_AVION", allocationSize = 1)
	@Column(name="ID_AVION")
	private Long id;

	@Column(name="NUM_REGISTRO")
	private Long numRegistro;

	@Column(name="TIPO")
	private String tipo;

	@Column(name="CODIGO_MODELO")
	private String codigoModelo;

	@Column(name="CAPACIDAD")
	private Long capacidad;

	@Column(name="FECHA_PRIMER_VUELO")
	private LocalDate fechaPrimerVuelo;

	@Column(name="ID_ESTATUS")
	private Long estatus;

	@ManyToOne
	@JoinColumn(name="ID_AEROLINEA", referencedColumnName = "ID_AEROLINEA")
	private Aerolinea aerolinea;
	
	

	public Avion(Long id, Long numRegistro, String tipo, String codigoModelo, Long capacidad,
			LocalDate fechaPrimerVuelo, Long estatus, Aerolinea aerolinea) {
		super();
		this.id = id;
		this.numRegistro = numRegistro;
		this.tipo = tipo;
		this.codigoModelo = codigoModelo;
		this.capacidad = capacidad;
		this.fechaPrimerVuelo = fechaPrimerVuelo;
		this.estatus = estatus;
		this.aerolinea = aerolinea;
	}
	
	

	public Avion() {
		// TODO Auto-generated constructor stub
	}



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

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	
}
