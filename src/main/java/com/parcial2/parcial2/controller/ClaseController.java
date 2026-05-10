package com.parcial2.parcial2.controller;

import com.parcial2.parcial2.model.Clase;
import com.parcial2.parcial2.dto.ClaseDTO;
import com.parcial2.parcial2.service.ClaseService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {
    @Autowired
    private ClaseService claseService;

    @GetMapping("/listarClases")
    public ResponseEntity<?> listarClases() { 
        List<ClaseDTO> clases = claseService.listarTodos(); 

        if (clases.isEmpty()) {
            return new ResponseEntity<>("No hay clases registradas", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(clases, HttpStatus.OK);
    }

    @GetMapping("/buscarClase/{id}")
    public ResponseEntity<?> obtenerClase(@PathVariable Integer id) {
        try {
            ClaseDTO claseDTO = claseService.obtenerPorId(id);
            return new ResponseEntity<>(claseDTO, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @PatchMapping("/modificarClase") 
    public ResponseEntity<?> modificarClase(@Valid @RequestBody Clase clase) {
        try {
            ClaseDTO clase_original = claseService.actualizar(clase);
            return new ResponseEntity<>(clase_original, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/guardarClase")
    public ResponseEntity<?> guardar(@Valid @RequestBody Clase clase) {
        try {
            ClaseDTO claseDTO = claseService.guardar(clase);
            return new ResponseEntity<>(claseDTO, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminarClase/{id}")
    public ResponseEntity<?> eliminarClase(@PathVariable Integer id)  {
        try {
            String resultado = claseService.eliminar(id);
            return new ResponseEntity<>(resultado, HttpStatus.OK);
            
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}