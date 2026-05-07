package com.parcial2.parcial2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcial2.parcial2.model.Arma;
import com.parcial2.parcial2.service.ArmaService;

@RestController
@RequestMapping("/api/v1/armas")
public class ArmaController {

    @Autowired
    private ArmaService armaService;
    //Agregar

    @PostMapping("")
    public ResponseEntity<?> agregarArma(@RequestBody Arma arma) {
        try {
            Arma guardado = armaService.agregarArma(arma);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
//Eliminar
//Modificar
//Buscar
//Mostrar todos

