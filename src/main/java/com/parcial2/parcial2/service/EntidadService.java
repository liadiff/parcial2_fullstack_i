package com.parcial2.parcial2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.dto.EntidadDTO;
import com.parcial2.parcial2.model.Entidad;
import com.parcial2.parcial2.repository.EntidadRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EntidadService {

    @Autowired
    private EntidadRepository entidadRepository;

    //Crear
    public Entidad crearEntidad(Entidad entidad) {
        if (entidadRepository.findByNombre(entidad.getNombre())) {
            return null;
        }
        return entidadRepository.save(entidad);
    }

    //Eliminar
    public String eliminarEntidad(Integer id) {
        Entidad entidadEliminar = entidadRepository.findById(id).orElseThrow(() -> new RuntimeException("La entidad con ID " + id + " no existe"));
        entidadRepository.delete(entidadEliminar);
        return "Se ha eliminado al heroe " + entidadEliminar.getNombre();
    }

    //Modificar
    public Entidad modificarEntidad(Integer id, Entidad entidadNueva) {
        Entidad entidadModificar = entidadRepository.findById(id).orElseThrow(() -> new RuntimeException("La entidad con ID " + id + " no existe"));
        entidadModificar.setArma(entidadNueva.getArma());
        entidadModificar.setArmadura(entidadNueva.getArmadura());
        entidadModificar.setClase(entidadNueva.getClase());
        entidadModificar.setJugable(entidadNueva.getJugable());
        entidadModificar.setRaza(entidadNueva.getRaza());
        entidadModificar.setNombre(entidadNueva.getNombre());
        return entidadRepository.save(entidadModificar);
    }

    //Buscar por id
    public Entidad buscarEntidad(Integer id) {
        return entidadRepository.findById(id).orElseThrow(() -> new RuntimeException("La entidad con ID " + id + " no existe"));
    }

    //Mostrar entidades jugables
    public List<EntidadDTO> mostrarEntidadesJugables() {
        List<Entidad> listaEntidades = entidadRepository.findAll();
        List<Entidad> listaEntidadesJugables = new ArrayList<>();
        List<EntidadDTO> listaEntidadesJugablesDTO = new ArrayList<>();
        for (Entidad entidad : listaEntidades) {
            if (entidad.getJugable()) {
                listaEntidadesJugables.add(entidad);
            }
        }
        for (Entidad entidad : listaEntidadesJugables) {
            listaEntidadesJugablesDTO.add(convertirEntidadADTO(entidad));
        }
        return listaEntidadesJugablesDTO;
    }

    //Mostrar entidades no jugables
    public List<EntidadDTO> mostrarEntidadesNoJugables() {
        List<Entidad> listaEntidades = entidadRepository.findAll();
        List<Entidad> listaEntidadesNoJugables = new ArrayList<>();
        List<EntidadDTO> listaEntidadNoJugablesDTO = new ArrayList<>();
        for (Entidad entidad : listaEntidades) {
            if (!entidad.getJugable()) {
                listaEntidadesNoJugables.add(entidad);
            }
        }

        for (Entidad entidad : listaEntidadesNoJugables) {
            listaEntidadNoJugablesDTO.add(convertirEntidadADTO(entidad));
        }
        return listaEntidadNoJugablesDTO;
    }

    //Convertir DTO
    public EntidadDTO convertirEntidadADTO(Entidad entidad) {
        EntidadDTO entidadDTO = new EntidadDTO();
        entidadDTO.setNombre(entidad.getNombre());
        entidadDTO.setArma(entidad.getArma().getNombre());
        entidadDTO.setArmadura(entidad.getArmadura().getNombre());
        entidadDTO.setRaza(entidad.getRaza().getNombre());
        entidadDTO.setClase(entidad.getClase().getNombre());
        if (entidad.getJugable()) {
            entidadDTO.setJugable("Jugador");
        } else {
            entidadDTO.setJugable("NPC");
        }
        return entidadDTO;
    }
    /*
    //----------------------USO INTERNO--------------------------------//
    //Mostrar entidades jugables
    public List<Entidad> EntidadesJugables() {
        List<Entidad> listaEntidades = entidadRepository.findAll();
        List<Entidad> listaEntidadesJugables = new ArrayList<>();
        for (Entidad entidad : listaEntidades) {
            if (entidad.getJugable()) {
                listaEntidadesJugables.add(entidad);
            }
        }
        return listaEntidadesJugables;
    }
    public List<Entidad> EntidadesNoJugables() {
        List<Entidad> listaEntidades = entidadRepository.findAll();
        List<Entidad> listaEntidadesNoJugables = new ArrayList<>();
        for (Entidad entidad : listaEntidades) {
            if (!entidad.getJugable()) {
                listaEntidadesNoJugables.add(entidad);
            }
        }
        return listaEntidadesNoJugables;
    }
     */
}
