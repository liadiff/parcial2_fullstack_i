package com.parcial2.parcial2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parcial2.parcial2.dto.EntidadDTO;
import com.parcial2.parcial2.model.Entidad;
import com.parcial2.parcial2.service.EntidadService;

@Controller
@RequestMapping("/api/v1/entidades")
public class EntidadController {

    @Autowired
    private EntidadService entidadService;
    //Crear
    @PostMapping("/crearEntidad")
    public ResponseEntity<?> crearEntidad(@RequestBody Entidad entidad) {
        try {
            Entidad EntidadNueva = entidadService.crearEntidad(entidad);
            if (EntidadNueva == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ya existe una entidad con ese nombre");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(entidadService.convertirEntidadADTO(EntidadNueva));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear la entidad");
        }
    }
    //Eliminar
    @DeleteMapping("/eliminarEntidad/{id}")
    public ResponseEntity<?> eliminarEntidad(@PathVariable Integer id){
        try {
            String mensaje = entidadService.eliminarEntidad(id);
            return ResponseEntity.ok(mensaje);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    //Modificar
    @PatchMapping("/modificarEntidad/{id}")
    public ResponseEntity<?> modificarEntidad (@PathVariable Integer id, Entidad entidad){
        try {
            Entidad entidadActualizada = entidadService.modificarEntidad(id, entidad);
            return ResponseEntity.ok(entidadService.convertirEntidadADTO(entidadActualizada));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    //Buscar por id
    @GetMapping("/buscarEntidad/{id}")
    public ResponseEntity<?> buscarEntidad(@PathVariable Integer id){
        try {
            Entidad entidad = entidadService.buscarEntidad(id);
            return ResponseEntity.ok(entidadService.convertirEntidadADTO(entidad));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    //Buscar jugables

    @GetMapping("/buscarEntidadesJugables")
    public ResponseEntity<?> buscarEntidadesJugables(){
        List<EntidadDTO> entidadesJugables = entidadService.mostrarEntidadesJugables();
        if(entidadesJugables.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No existen jugadores registrados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entidadesJugables);
    }
    //Buscar no jugables
    @GetMapping("/buscarEntidadesNoJugables")
    public ResponseEntity<?> buscarEntidadesNoJugables(){
        List<EntidadDTO> entidadesNoJugables = entidadService.mostrarEntidadesNoJugables();
        if(entidadesNoJugables.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No existen NPCs registrados");
        }
        return ResponseEntity.status(HttpStatus.OK).body(entidadesNoJugables);
    }
    
}
