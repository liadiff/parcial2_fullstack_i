<<<<<<< HEAD
package com.parcial2.parcial2.service;

import com.parcial2.parcial2.model.Raza;
import com.parcial2.parcial2.repository.RazaRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class RazaService {
    @Autowired
    private RazaRepository razaRepository;

    public List<Raza> listarTodos() {
        return razaRepository.findAll();
    }

    public Raza guardar(Raza raza) {
        return razaRepository.save(raza);
    }
=======
<<<<<<< Updated upstream
package com.parcial2.parcial2.service;

import com.parcial2.parcial2.model.Raza;
import com.parcial2.parcial2.repository.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RazaService {
    @Autowired
    private RazaRepository razaRepository;

    public List<Raza> listarTodos() {
        return razaRepository.findAll();
    }

    public Raza guardar(Raza raza) {
        return razaRepository.save(raza);
    }
=======
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

    public void eliminar(Integer id) {
        if (!razaRepository.existsById(id)) {
            throw new RuntimeException("Error: No existe la raza con ID " + id);
        }
        razaRepository.deleteById(id);
    }

    private RazaDTO convertirADTO(Raza raza) {
        RazaDTO dto = new RazaDTO();
        
        // Mapeo directo según tu RazaDTO
        dto.setNombre(raza.getNombre());
        dto.setDescripcion(raza.getDescripcion());
        
        return dto;
    }
>>>>>>> Stashed changes
>>>>>>> origin/Nicolas
}