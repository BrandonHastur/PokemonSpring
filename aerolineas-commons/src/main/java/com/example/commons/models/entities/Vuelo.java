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
@Table(name="VUELO")
public class Vuelo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEO_VUELO")
	@SequenceGenerator(name="SEO_VUELO", sequenceName = "SEO_VUELO", allocationSize = 1)
	@Column(name="ID_VUELO")
	private Long id;
	

	@Column(name="CODIGO_VUELO")
	private String codigoVuelo;
	
	
	@ManyToOne
	@JoinColumn(name="ID_AVION", referencedColumnName = "ID_AVION")
	private Avion avion;
	
	
	@ManyToOne
	@JoinColumn(name="ID_ORIGEN", referencedColumnName = "ID_AEROPUERTO")
	private Aeropuerto Origen;
	
	
	@ManyToOne
	@JoinColumn(name="ID_DESTINO", referencedColumnName = "ID_AEROPUERTO")
	private Aeropuerto Destino;
	
	
	@Column(name="FECHA_SALIDA")
	private LocalDate fechaSalida;
	
	
	@Column(name="ID_ESTATUS")
	private long estatus;

	
	
	public Vuelo(Long id, String codigoVuelo, Avion avion, Aeropuerto origen, Aeropuerto destino, LocalDate fechaSalida,
			long estatus) {
		super();
		this.id = id;
		this.codigoVuelo = codigoVuelo;
		this.avion = avion;
		Origen = origen;
		Destino = destino;
		this.fechaSalida = fechaSalida;
		this.estatus = estatus;
	}

	
	public Vuelo() {
		// TODO Auto-generated constructor stub
	}



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

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Aeropuerto getOrigen() {
		return Origen;
	}

	public void setOrigen(Aeropuerto origen) {
		Origen = origen;
	}

	public Aeropuerto getDestino() {
		return Destino;
	}

	public void setDestino(Aeropuerto destino) {
		Destino = destino;
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
