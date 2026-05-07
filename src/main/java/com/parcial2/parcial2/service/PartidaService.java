package com.parcial2.parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.model.Partida;
import com.parcial2.parcial2.repository.PartidaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PartidaService {
    
    @Autowired
    PartidaRepository partidaRepository;

    public List<Partida> obtenerTodos() {
        return partidaRepository.findAll();
    }

    public Partida buscarPorId(Integer id) {
        return partidaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("La partida " + id + " no esta en los registros"));
    }

    public Partida guardar(Partida partida) {
        return partidaRepository.save(partida);
    }

    public String eliminar(Integer id) {
        try {
            Partida partida = partidaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se ha podido eliminar la partida: Partida " + id + " inexistente"));
            
            partidaRepository.delete(partida);
            return "Partida " + id + " eliminada exitosamente";

        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}
