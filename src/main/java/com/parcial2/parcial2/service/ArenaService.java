package com.parcial2.parcial2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.model.Arena;
import com.parcial2.parcial2.repository.ArenaRepository;
import com.parcial2.parcial2.dto.ArenaDTO;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ArenaService {

    @Autowired
    ArenaRepository arenaRepository;

    public List<ArenaDTO> listarArenas() {
        List<ArenaDTO> arenas = new ArrayList<>();
        for (Arena a : arenaRepository.findAll()) {
            arenas.add(convertirDTO(a));
        }
        return arenas;
    }    

    public ArenaDTO buscarPorId(Integer id) {
        return convertirDTO(arenaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("La arena " + id + " no esta en los registros")));
    }

    public ArenaDTO guardarArena(Arena arena) {
        return convertirDTO(arenaRepository.save(arena) );
    }

    public String eliminarArena(Integer id) {
        try {
            Arena arena = arenaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se ha podido eliminar la arena: Arena " + id + " inexistente"));
            
            arenaRepository.delete(arena);
            return "Arena " + id + " eliminada exitosamente";

        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public Float obtenerMultiplicadorDeVelocidad(Integer id) {
        Arena arena = arenaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha podido obtener el multiplicador de velocidad de la Arena: Arena " + id + " inexistente"));

        return arena.getMultiplicadorDeVelocidad();
    }

    public Float obtenerMultiplicadorDeHP(Integer id) {
        Arena arena = arenaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha podido obtener el multiplicador de HP de la Arena: Arena " + id + " inexistente"));

        return arena.getMultiplicadorDeHP();
    }

    public ArenaDTO actualizarArena(Integer id, Arena arena) {
        Arena arena_original = arenaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha podido actualizar la Arena: Arena " + id + " inexistente"));
        
        if (arena.getNombre() != null || (!arena.getNombre().isBlank())) {
            arena_original.setNombre(arena.getNombre());
        }
        
        if (arena.getMultiplicadorDeVelocidad() != null) {
            arena_original.setMultiplicadorDeVelocidad(arena.getMultiplicadorDeVelocidad());
        }

        if (arena.getMultiplicadorDeHP() != null) {
            arena_original.setMultiplicadorDeHP(arena.getMultiplicadorDeHP());
        }

        return convertirDTO(arenaRepository.save(arena_original));
    }
    
    private ArenaDTO convertirDTO(Arena arena) {
        ArenaDTO arenaDTO = new ArenaDTO();
        arenaDTO.setId(arena.getId());
        arenaDTO.setNombre(arena.getNombre());
        arenaDTO.setMultiplicadorDeVelocidad(arena.getMultiplicadorDeVelocidad());
        arenaDTO.setMultiplicadorDeHP(arena.getMultiplicadorDeHP());
        return arenaDTO;
    }
}
