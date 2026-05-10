package com.parcial2.parcial2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcial2.parcial2.model.Entidad;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Integer> {

    Boolean findByNombre (String nombre);
}
