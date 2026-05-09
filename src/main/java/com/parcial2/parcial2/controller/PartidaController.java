package com.parcial2.parcial2.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.parcial2.parcial2.service.PartidaService;

import jakarta.validation.Valid;

import com.parcial2.parcial2.dto.PartidaDTO;
import com.parcial2.parcial2.model.Entidad;
import com.parcial2.parcial2.model.Partida;

@RestController
@RequestMapping("/api/v1/partidas")
public class PartidaController {
    
    @Autowired
    private PartidaService partidaService;

    @GetMapping
    public ResponseEntity<?> listarPartidas() {
        
        List<PartidaDTO> partidas = partidaService.listarPartidas();

        if (partidas.isEmpty()) {
            return new ResponseEntity<>("No hay partidas registradas", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(partidas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            PartidaDTO partidaDTO = partidaService.buscarPorId(id);
            return new ResponseEntity<>(partidaDTO, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> guardarPartida(@Valid @RequestBody Partida partida) {
        try {
            PartidaDTO partidaDTO = partidaService.guardarPartida(partida);
            return new ResponseEntity<>(partidaDTO, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPartida(@PathVariable Integer id) {
        try {
            String resultado = partidaService.eliminarPartida(id);
            return new ResponseEntity<>(resultado, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> actualizarPartida(@PathVariable Integer id, @Valid @RequestBody Partida partida) {
        try {
            PartidaDTO partida_actualizada = partidaService.actualizarPartida(id, partida);
            return new ResponseEntity<>(partida_actualizada, HttpStatus.OK);
        
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/jugador")
    public ResponseEntity<?> obtenerJugador(@PathVariable Integer id) {
        try {
            Entidad entidad = partidaService.obtenerJugador(id);
            return new ResponseEntity<>(entidad, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/enemigo")
    public ResponseEntity<?> obtenerEnemigo(@PathVariable Integer id) {
        try {
            Entidad entidad = partidaService.obtenerEnemigo(id);
            return new ResponseEntity<>(entidad, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
