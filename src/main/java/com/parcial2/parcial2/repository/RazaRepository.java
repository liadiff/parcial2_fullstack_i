package com.parcial2.parcial2.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.parcial2.parcial2.model.Raza;


@Repository
public interface RazaRepository extends org.springframework.data.jpa.repository.JpaRepository<Raza, Integer> {
    List<Raza> findByNombre(String nombre);

    List<Raza> getByDescripcion(String descripcion);   
}