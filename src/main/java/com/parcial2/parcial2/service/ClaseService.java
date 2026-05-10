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

    public void eliminar(Integer id) {
        if (!claseRepository.existsById(id)) {
            throw new RuntimeException("Error: No existe la clase con ID " + id);
        }
        claseRepository.deleteById(id);
    }

    private ClaseDTO convertirADTO(Clase clase) {
        ClaseDTO dto = new ClaseDTO();
        dto.setNombre(clase.getNombre());
        dto.setDescripcion(clase.getDescripcion());
        dto.setMultDano(clase.getMult_dano()); 
        
        return dto;
    }
}