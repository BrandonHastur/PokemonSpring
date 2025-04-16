package com.example.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class CommonMapper<D, E, R extends JpaRepository<E, Long>> {

    @Autowired
    protected R repository;

    public D entityToDto(E entity) {
        return null;
    }

    public E dtoToEntity(D dto) {
        return null;
    }
    
}
