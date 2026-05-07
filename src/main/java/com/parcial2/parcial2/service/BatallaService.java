package com.parcial2.parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.model.Batalla;
import com.parcial2.parcial2.repository.BatallaRepository;

@Service
public class BatallaService {
    
    @Autowired
    BatallaRepository batallaRepository;

    public List<Batalla> obtenerTodos() {
        return batallaRepository.findAll();
    }

    public Batalla buscarPorId(Integer id) {
        return batallaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("La batalla " + id + " no esta en los registros"));
    }

    public Batalla guardar(Batalla batalla) {
        return batallaRepository.save(batalla);
    }

    public String eliminar(Integer id) {
        try {
            Batalla batalla = batallaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se ha podido eliminar la batalla: Batalla " + id + " inexistente"));
            
            batallaRepository.delete(batalla);
            return "batalla " + id + " eliminada exitosamente";

        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}
