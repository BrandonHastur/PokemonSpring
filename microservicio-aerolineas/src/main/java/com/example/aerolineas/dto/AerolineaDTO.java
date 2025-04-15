package com.example.aerolineas.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class AerolineaDTO {

    @NotNull(message = "El ID no debe ser nulo")
    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "La IATA no puede estar en blanco")
    private String iata;

    @Min(value = 1, message = "El estatus no puede ser menor a 1")
    @Max(value = 2, message = "El estatus no puede ser mayor a 2")
    private Long estatus;

    @NotNull
    private String pais;

    @Past(message = "La fecha no puede ser anterior a la fecha actual")
    private LocalDate fechaFundacion;

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
