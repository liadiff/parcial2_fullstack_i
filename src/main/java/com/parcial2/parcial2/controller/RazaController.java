package com.parcial2.parcial2.controller;

import com.parcial2.parcial2.model.Raza;
import com.parcial2.parcial2.dto.RazaDTO;
import com.parcial2.parcial2.service.RazaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/raza")
public class RazaController {

    @Autowired
    private RazaService razaService;

    @GetMapping("/mostrarRazas")
    public ResponseEntity<?> listarRazas() { 
        List<RazaDTO> razas = razaService.listarTodos();
        
        if (razas.isEmpty()) {
            return new ResponseEntity<>("No hay razas registradas", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(razas, HttpStatus.OK);
    }

    @GetMapping("/buscarRaza/{id}")
    public ResponseEntity<?> buscarRaza(@PathVariable Integer id) {
        try {
            RazaDTO raza = razaService.obtenerPorId(id);
            return new ResponseEntity<>(raza, HttpStatus.OK); 
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/modificarRaza") 
    public ResponseEntity<?> modificarRaza(@Valid @RequestBody Raza raza) {
        try {
            RazaDTO raza_original = razaService.actualizar(raza);
            return new ResponseEntity<>(raza_original, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/guardarRaza")
    public ResponseEntity<?> guardar(@RequestBody Raza raza) {
        try {
            RazaDTO razaDTO = razaService.guardar(raza);
            return new ResponseEntity<>(razaDTO, HttpStatus.OK);
            
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminarRaza/{id}") 
    public ResponseEntity<?> eliminarRaza(@PathVariable Integer id) {
        try {
            String resultado = razaService.eliminar(id);
            return new ResponseEntity<>(resultado, HttpStatus.OK);
            
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}