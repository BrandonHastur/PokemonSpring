package com.example.commons.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="AEROLINEA")
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEO_AEROLINEA")
    @SequenceGenerator(name = "SEO_AEROLINEA", sequenceName = "SEO_AEROLINEA", allocationSize= 1)
    @Column(name = "ID_AEROLINEA")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "IATA")
    private String iata;
    
    @Column(name = "PAIS")
    private String pais;
    
    @Column(name = "FECHA_FUNDACION")
    private LocalDate fechaFundacion;

    @Column(name = "ID_ESTATUS")
    private Long estatus;

    
    

    public Aerolinea(Long id, String nombre, String iata, String pais, LocalDate fechaFundacion, Long estatus) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.iata = iata;
		this.pais = pais;
		this.fechaFundacion = fechaFundacion;
		this.estatus = estatus;
	}

	public Aerolinea() {
		// TODO Auto-generated constructor stub
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

    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public Long getEstatus() {
        return estatus;
    }

    public void setEstatus(Long estatus) {
        this.estatus = estatus;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }
	
	
	
	
}
