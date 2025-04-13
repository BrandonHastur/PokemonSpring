package com.example.productos.models.entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTO_PRUEBA")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUCTO")
    private Long id;
    
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
    
    @Column(name = "PRECIO", nullable = false)
    private Double precio;
    
    @Column(name = "MARCA")
    private String marca;
    
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;
    
    @Column(name = "FECHA_CREACION", updatable = false)
    private Date fechaCreacion;
    
    @PrePersist
    private void prePersist() {
        this.fechaCreacion = new Date();
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
    
    public Double getPrecio() {
        return precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}