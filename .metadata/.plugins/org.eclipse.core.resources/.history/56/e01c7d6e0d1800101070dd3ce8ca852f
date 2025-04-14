package com.example.pokemon.models.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_POKEMON")
public class Tipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POKEMON_SEQ")
	@SequenceGenerator(name = "POKEMON_SEQ",sequenceName = "POKEMON_SEQ")
	@Column(name="ID_TIPO")
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@ManyToMany(mappedBy = "tipos")
	private Set<Pokemon> pokemones;

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

	public Set<Pokemon> getPokemones() {
		return pokemones;
	}

	public void setPokemones(Set<Pokemon> pokemones) {
		this.pokemones = pokemones;
	}

	public Tipo() {
		this.pokemones = new HashSet<>();
	}

	
	
	
	
	
}
