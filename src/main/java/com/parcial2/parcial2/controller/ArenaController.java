package com.parcial2.parcial2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.parcial2.parcial2.service.ArenaService;

import jakarta.validation.Valid;

import com.parcial2.parcial2.dto.ArenaDTO;
import com.parcial2.parcial2.model.Arena;

import java.util.List;

@RestController
@RequestMapping("/api/v1/arenas")
public class ArenaController {
    
    @Autowired
    private ArenaService arenaService;
    
    @GetMapping
    public ResponseEntity<?> listarArenas() {
        List<ArenaDTO> arenas = arenaService.listarArenas();

        if (arenas.isEmpty()) {
            return new ResponseEntity<>("No hay arenas registradas", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(arenas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            ArenaDTO arenaDTO = arenaService.buscarPorId(id);
            return new ResponseEntity<>(arenaDTO, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarPartida(@Valid @RequestBody Arena arena) {
        try {
            ArenaDTO arenaDTO = arenaService.guardarArena(arena);
            return new ResponseEntity<>(arenaDTO, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPartid(@PathVariable Integer id) {
        try {
            String resultado = arenaService.eliminarArena(id);
            return new ResponseEntity<>(resultado, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> actualizarArena(@PathVariable Integer id, @Valid @RequestBody Arena arena) {
        try {
            ArenaDTO arena_actualizada = arenaService.actualizarArena(id, arena);
            return new ResponseEntity<>(arena_actualizada, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/multiplicadorvelocidad") 
    public ResponseEntity<?> obtenerMultiplicadorVelocidad(@PathVariable Integer id) {
        try {
            Float multiplicadorVelocidad = arenaService.obtenerMultiplicadorDeHP(id);
            return new ResponseEntity<>(multiplicadorVelocidad, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/multiplicadorvelocidad") 
    public ResponseEntity<?> obtenerMultiplicadorHP(@PathVariable Integer id) {
        try {
            Float multiplicadorHP = arenaService.obtenerMultiplicadorDeHP(id);
            return new ResponseEntity<>(multiplicadorHP, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
