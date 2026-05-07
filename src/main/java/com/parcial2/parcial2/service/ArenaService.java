package com.parcial2.parcial2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.model.Arena;
import com.parcial2.parcial2.repository.ArenaRepository;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class ArenaService {

    @Autowired
    ArenaRepository arenaRepository;

    public List<Arena> obtenerTodos() {
        return arenaRepository.findAll();
    }    

    public Arena buscarPorId(Integer id) {
        return arenaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("La arena " + id + " no esta en los registros"));
    }

    public Arena guardar(Arena arena) {
        return arenaRepository.save(arena);
    }

    public String eliminar(Integer id) {
        try {
            Arena arena = arenaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se ha podido eliminar la arena: Arena " + id + " inexistente"));
            
            arenaRepository.delete(arena);
            return "Arena " + id + " eliminada exitosamente";

        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}
