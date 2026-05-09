package com.parcial2.parcial2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.dto.BatallaDTO;
import com.parcial2.parcial2.model.Arena;
import com.parcial2.parcial2.model.Batalla;
import com.parcial2.parcial2.repository.BatallaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BatallaService {
    
    @Autowired
    BatallaRepository batallaRepository;

    public List<BatallaDTO> listarBatallas() {
        List<BatallaDTO> batallas = new ArrayList<>();
        for (Batalla b : batallaRepository.findAll()) {
            batallas.add(convertirDTO(b));
        }
        return batallas;
    }

    public BatallaDTO buscarPorId(Integer id) {
        return convertirDTO(batallaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("La batalla " + id + " no esta en los registros")));
    }

    public BatallaDTO guardarBatalla(Batalla batalla) {
        return convertirDTO(batallaRepository.save(batalla));
    }

    public String eliminarBatalla(Integer id) {
        try {
            Batalla batalla = batallaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No se ha podido eliminar la batalla: Batalla " + id + " inexistente"));
            
            batallaRepository.delete(batalla);
            return "Batalla " + id + " eliminada exitosamente";

        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public Boolean obtenerFinalizado(Integer id) {
        Batalla batalla = batallaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha podido obtener el valor de finalizado: Batalla " + id + " inexistente"));

        return batalla.getFinalizado();
    }

    public Arena obtenerArena(Integer id) {
        Batalla batalla = batallaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha podido obtener la arena de la batalla: Batalla " + id + " inexistente"));

        return batalla.getArena();
    }
 
    public BatallaDTO actualizarBatalla(Integer id, Batalla batalla) {
        Batalla batalla_original = batallaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha podido actualizar la batalla: Batalla " + id + " inexistente"));

        if (batalla.getFinalizado() != null) {
            batalla_original.setFinalizado(batalla.getFinalizado());
        }

        if (batalla.getArena() != null) {
            batalla_original.setArena(batalla.getArena());
        }

        return convertirDTO(batallaRepository.save(batalla_original));
    }

    private BatallaDTO convertirDTO(Batalla batalla) {
        BatallaDTO batallaDTO = new BatallaDTO();

        batallaDTO.setId(batalla.getId());
        batallaDTO.setFinalizado(batalla.getFinalizado());
        batallaDTO.setArena(batalla.getArena());

        return batallaDTO;
    }
}
