package com.example.pokemon.services;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
	List<T> listar();
	Optional<T> obtenerPorId(Long id);
	T insertar(T entity);
	T editar(T entity, Long id);
	T eliminar(Long id);
}
