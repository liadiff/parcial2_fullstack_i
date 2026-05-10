package com.parcial2.parcial2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.dto.ArmaduraDTO;
import com.parcial2.parcial2.model.Armadura;
import com.parcial2.parcial2.repository.ArmaduraRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArmaduraService {

    @Autowired
    private ArmaduraRepository armaduraRepository;

    public List<ArmaduraDTO> listarTodos() {
        List<ArmaduraDTO> listaDtos = new ArrayList<>();
        for (Armadura armadura : armaduraRepository.findAll()) {
            listaDtos.add(convertirADTO(armadura));
        }
        return listaDtos;
    }

    public ArmaduraDTO obtenerPorId(Integer id) {
        Armadura armadura = armaduraRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Armadura no encontrada"));
        return convertirADTO(armadura);
    }

    public ArmaduraDTO guardar(Armadura nuevaArmadura) {
        Armadura armaduraGuardada = armaduraRepository.save(nuevaArmadura);
        return convertirADTO(armaduraGuardada);
    }

    public ArmaduraDTO actualizar(Armadura armadura) {
        Armadura armaduraActualizada = armaduraRepository.save(armadura);
        return convertirADTO(armaduraActualizada);
    }

    public String eliminar(Integer id) {
        Armadura armadura = armaduraRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se ha podido eliminar la arena: Arena " + id + " inexistente"));
            
        armaduraRepository.delete(armadura);
        return "Armadura " + id + " eliminada exitosamente";
    }

    private ArmaduraDTO convertirADTO(Armadura armadura) {
        ArmaduraDTO dto = new ArmaduraDTO();
        
        dto.setId(armadura.getId());
        dto.setNombre(armadura.getNombre());
        dto.setPuntosVida(armadura.getHp());
        dto.setProteccion(armadura.getProteccion());
        
        return dto;
    }
}