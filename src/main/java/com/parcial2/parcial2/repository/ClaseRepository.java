package com.parcial2.parcial2.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcial2.parcial2.model.Clase;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Integer> {
    List<Clase> findByNombre(String nombre);

    List<Clase> getByMult_dano(Float mult_dano);

    List<Clase> getByMult_veloc_ataque(Float mult_veloc_ataque);

    List<Clase> getByMult_hp(Float mult_hp);

    List<Clase> getByDescripcion(String descripcion);

}
