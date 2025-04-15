package com.example.commons.services;

import java.util.List;
import java.util.Optional;

public interface CommonService<D> { //D de DTO


    List<D> listar();

    Optional<D> obtener(Long id);

    D editar(D entity, Long id);

    D insertar(D dto);

    D eliminar(Long id);
	
    
}
