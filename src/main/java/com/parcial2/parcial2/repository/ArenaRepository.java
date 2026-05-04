package com.parcial2.parcial2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parcial2.parcial2.model.Arena;

public interface ArenaRepository extends JpaRepository<Arena, Integer> {

    Arena findByID(Integer id);
    
}
