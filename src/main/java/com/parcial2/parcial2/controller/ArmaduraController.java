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

import com.parcial2.parcial2.dto.ArmaduraDTO;

import com.parcial2.parcial2.model.Armadura;
import com.parcial2.parcial2.service.ArmaduraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/armadura")
public class ArmaduraController {

    @Autowired
    private ArmaduraService armaduraService;

    @GetMapping("/mostrarArmaduras")
    public ResponseEntity<?> listar() { 
        List<ArmaduraDTO> armaduras = armaduraService.listarTodos();

        if (armaduras.isEmpty()) {
            return new ResponseEntity<>("No hay armaduras registradas", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(armaduras, HttpStatus.OK);
    }

    @GetMapping("/buscarArmadura/{id}")
    public ResponseEntity<?> buscarArmadura(@PathVariable Integer id) {
        try {
            ArmaduraDTO armadura = armaduraService.obtenerPorId(id);
            return new ResponseEntity<>(armadura, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/modificarArmadura/{id}")
    public ResponseEntity<?> modificarArmadura(@Valid @RequestBody Armadura armadura) {
        try {
            ArmaduraDTO armadura_original = armaduraService.actualizar(armadura);
            return new ResponseEntity<>(armadura_original, HttpStatus.OK);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/guardarArmadura")
    public ResponseEntity<?> guardar(@Valid @RequestBody Armadura armadura) {
        try {
            ArmaduraDTO armaduraDTO = armaduraService.guardar(armadura);
            return new ResponseEntity<>(armaduraDTO, HttpStatus.OK);
            
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminarArmadura/{id}") 
    public ResponseEntity<?> eliminarArmadura(@PathVariable Integer id) {
        try {
            String resultado = armaduraService.eliminar(id);
            return new ResponseEntity<>(resultado, HttpStatus.OK);
            
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}