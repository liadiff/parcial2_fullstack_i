package com.parcial2.parcial2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.dto.ClaseDTO;
import com.parcial2.parcial2.model.Clase;
import com.parcial2.parcial2.repository.ClaseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    public List<ClaseDTO> listarTodos() {
        List<ClaseDTO> listaDtos = new ArrayList<>();
        for (Clase clase : claseRepository.findAll()) {
            listaDtos.add(convertirADTO(clase));
        }
        return listaDtos;
    }

    public ClaseDTO obtenerPorId(Integer id) {
        Clase clase = claseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));
        return convertirADTO(clase);
    }

    public ClaseDTO guardar(Clase nuevaClase) {
        Clase claseGuardada = claseRepository.save(nuevaClase);
        return convertirADTO(claseGuardada);
    }

    public ClaseDTO actualizar(Clase clase) {
        Clase claseActualizada = claseRepository.save(clase);
        return convertirADTO(claseActualizada);
    }

    public String eliminar(Integer id) {
        Clase clase = claseRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha podido eliminar la Clase: Clase " + id + " inexistente"));

        claseRepository.delete(clase);
        return "Clase " + id + " eliminada exitosamente";
    }

    private ClaseDTO convertirADTO(Clase clase) {
        ClaseDTO dto = new ClaseDTO();
        dto.setId(clase.getId());
        dto.setNombre(clase.getNombre());
        dto.setDescripcion(clase.getDescripcion());
        dto.setMultDano(clase.getMult_dano()); 
        return dto;
    }
}