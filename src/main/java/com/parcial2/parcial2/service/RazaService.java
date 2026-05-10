package com.parcial2.parcial2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.dto.RazaDTO;
import com.parcial2.parcial2.model.Raza;
import com.parcial2.parcial2.repository.RazaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RazaService {

    @Autowired
    private RazaRepository razaRepository;

    public List<RazaDTO> listarTodos() {
        List<RazaDTO> listaDtos = new ArrayList<>();
        for (Raza raza : razaRepository.findAll()) {
            listaDtos.add(convertirADTO(raza));
        }
        return listaDtos;
    }

    public RazaDTO obtenerPorId(Integer id) {
        Raza raza = razaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Raza no encontrada"));
        return convertirADTO(raza);
    }

    public RazaDTO guardar(Raza nuevaRaza) {
        Raza razaGuardada = razaRepository.save(nuevaRaza);
        return convertirADTO(razaGuardada);
    }

    public RazaDTO actualizar(Raza raza) {
        Raza razaActualizada = razaRepository.save(raza);
        return convertirADTO(razaActualizada);
    }

    public String eliminar(Integer id) {
        Raza raza = razaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha podido eliminar la raza: Raza " + id + " inexistente"));
        
        razaRepository.delete(raza);
        return "Raza " + id + " eliminada exitosamente";
    }

    private RazaDTO convertirADTO(Raza raza) {
        RazaDTO dto = new RazaDTO();
        
        dto.setId(raza.getId());
        dto.setNombre(raza.getNombre());
        dto.setDescripcion(raza.getDescripcion());
        
        return dto;
    }
}