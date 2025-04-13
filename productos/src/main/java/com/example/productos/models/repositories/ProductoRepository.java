package com.example.productos.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.productos.models.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>{
	
}
