package com.example.commons.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.commons.CommonMapper;

public class CommonServiceImpl<D, E, M extends CommonMapper<D, E, R>,
R extends JpaRepository<E, Long>> implements CommonService<D>{
	
	//protected porque vamos a heredar este atributo de repositorio
    @Autowired
    protected R repository;

    @Autowired
    protected M mapper;

    @Override
    public List<D> listar() {
        return null;
    }

    @Override
    public Optional<D> obtener(Long id) {
        return Optional.empty();
    }

    @Override
    public D editar(D entity, Long id) {
        return null;
    }

    @Override
    public D insertar(D dto) {
        return null;
    }

    @Override
    public D eliminar(Long id) {
        return null;
    }
	
	
}
