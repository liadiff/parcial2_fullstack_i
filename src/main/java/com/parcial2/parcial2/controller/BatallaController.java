package com.parcial2.parcial2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcial2.parcial2.dto.BatallaDTO;
import com.parcial2.parcial2.model.Arena;
import com.parcial2.parcial2.model.Batalla;
import com.parcial2.parcial2.service.BatallaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/batallas")
public class BatallaController {
    
    @Autowired
    private BatallaService batallaService;

    @GetMapping
    public ResponseEntity<?> listarBatallas() {
        List<BatallaDTO> batallas = batallaService.listarBatallas();

        if (batallas.isEmpty()) {
            return new ResponseEntity<>("No hay batallas registradas", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(batallas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            BatallaDTO batallaDTO = batallaService.buscarPorId(id);
            return new ResponseEntity<>(batallaDTO, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> guardarBatalla(@Valid @RequestBody Batalla batalla) {
        try {
            BatallaDTO batallaDTO = batallaService.guardarBatalla(batalla);
            return new ResponseEntity<>(batallaDTO, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarBatalla(@PathVariable Integer id) {
        try {
            String resultado = batallaService.eliminarBatalla(id);
            return new ResponseEntity<>(resultado, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> actualizarPartida(@PathVariable Integer id, @Valid @RequestBody Batalla batalla) {
        try {
            BatallaDTO batalla_actualizada = batallaService.actualizarBatalla(id, batalla);
            return new ResponseEntity<>(batalla_actualizada, HttpStatus.OK);
        
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}/finalizado")
    public ResponseEntity<?> obtenerFinalizado(Integer id) {
        try {
            Boolean finalizada = batallaService.obtenerFinalizado(id);
            return new ResponseEntity<>(finalizada, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping("/{id}/arena")
    public ResponseEntity<?> obtenerArena(Integer id) {
        try {
            Arena arena = batallaService.obtenerArena(id);
            return new ResponseEntity<>(arena, HttpStatus.OK);
            
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
