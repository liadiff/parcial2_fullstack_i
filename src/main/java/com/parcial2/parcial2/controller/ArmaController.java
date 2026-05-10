package com.parcial2.parcial2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcial2.parcial2.dto.ArmaDTO;
import com.parcial2.parcial2.model.Arma;
import com.parcial2.parcial2.service.ArmaService;

@RestController
@RequestMapping("/api/v1/armas")
public class ArmaController {

    @Autowired
    private ArmaService armaService;
    //Agregar

    @PostMapping("/agregarArma")
    public ResponseEntity<?> agregarArma(@RequestBody Arma arma) {
        try {
            Arma guardado = armaService.agregarArma(arma);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //Eliminar
    @DeleteMapping("/EliminarArma/{id}")
    public ResponseEntity<String> eliminarArma(@PathVariable Integer id){
        try {
            String mensaje = armaService.eliminarArma(id);
            return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Modificar
    @PutMapping("/modificarArma/{id}")
    public ResponseEntity<?> modificarArma(@PathVariable Integer id, @RequestBody Arma arma){
        try {
            Arma armaModificada = armaService.modificarArma(arma, id);
            return ResponseEntity.ok(armaModificada);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Buscar

    @GetMapping("/buscarArma/{id}")
    public ResponseEntity <?> buscarArma(@PathVariable Integer id){
        try {
            ArmaDTO armaEncontrada = armaService.encontrarArma(id);
            return new ResponseEntity<>(armaEncontrada, HttpStatus.OK);
        } catch (RuntimeException e ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }  
    //Mostrar todos
    @GetMapping("/mostrarArmas")
    public ResponseEntity<?> mostrarArmas(){
        try {
            List<ArmaDTO> listaArmasDTO = armaService.mostrarTodas();
            return new ResponseEntity<>(listaArmasDTO,HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

