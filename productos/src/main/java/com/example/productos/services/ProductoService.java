package com.example.productos.services;

import java.util.List;
import java.util.Optional;
import com.example.productos.models.entities.Producto;

public interface ProductoService {
	List<Producto> listar();
	Optional<Producto> obtenerPorId(Long id);
	Producto insertar(Producto producto);
	Producto editar(Producto producto, Long id);
	Producto eliminar(Long id);
}
