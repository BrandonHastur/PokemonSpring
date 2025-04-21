package com.example.commons.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="AEROPUERTO")
public class Aeropuerto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEO_AEROPUERTO")
	@SequenceGenerator(name="SEO_AEROPUERTO", sequenceName = "SEO_AEROPUERTO", allocationSize = 1)
	@Column(name="ID_AEROPUERTO")
	private Long id;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="CODIGO")
	private String codigo;

	@Column(name="LATITUD")
	private String latitud;

	@Column(name="LONGITUD")
	private String longitud;

	@Column(name="PAIS")
	private String pais;

	@Column(name="ID_ESTATUS")
	private Long estatus;
		

	public Aeropuerto(Long id, String nombre, String codigo, String latitud, String longitud, String pais,
			Long estatus) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.latitud = latitud;
		this.longitud = longitud;
		this.pais = pais;
		this.estatus = estatus;
	}
	
	
	public Aeropuerto() {

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}
	
	
}
