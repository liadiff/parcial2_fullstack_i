package com.parcial2.parcial2.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parcial2.parcial2.dto.CategoriaArmaDTO;
import com.parcial2.parcial2.model.CategoriaArma;
import com.parcial2.parcial2.service.CategoriaArmaService;

@Controller
@RequestMapping("/api/v1/categoriaArmas")
public class CategoriaArmaController {

    @Autowired
    private CategoriaArmaService categoriaArmaService;

    //Agregar
    @PostMapping("/agregarCategoriaArma")
    public ResponseEntity<?> agregarCategoriaArma(@RequestBody CategoriaArma categoria) {
        try {
            CategoriaArma nuevaCategoriaArma = categoriaArmaService.agregarCategoriaArma(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaArmaService.convertirCategoriaArmaDTO(nuevaCategoriaArma));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //Eliminar
    @DeleteMapping("/eliminarCategoriaArma/{id}")
    public ResponseEntity<?> eliminarCategoriaArma(@PathVariable Integer id) {
        try {
            String mensaje = categoriaArmaService.eliminarCategoria(id);
            return ResponseEntity.ok(mensaje); // Retorna 200 OK con el mensaje de éxito
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //Modificar
    @PutMapping("/modificarCategoriaArma/{id}")
    public ResponseEntity<?> modificarCategoriaArma(@PathVariable Integer id, @RequestBody CategoriaArma categoriaArma) {
        try {
            CategoriaArma actualizada = categoriaArmaService.modificarCategoria(id, categoriaArma);
            return ResponseEntity.ok(categoriaArmaService.covertirCategoriaArmaDTO(actualizada));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //Buscar
    @GetMapping("/buscarCategoriaArma/{id}")
    public ResponseEntity<?> buscarCategoriaArma(@PathVariable Integer id) {
        try {
            CategoriaArma categoriaArma = categoriaArmaService.encontrarCategoria(id);
            CategoriaArmaDTO categoriaArmaDTO = categoriaArmaService.covertirCategoriaArmaDTO(categoriaArma);
            return ResponseEntity.ok(categoriaArmaDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //Mostrar todos
    @GetMapping("/mostrarCategoriaArmas")
    public ResponseEntity<?> mostrarCategoriaArmas(){
        try {
            List<CategoriaArmaDTO> listaCategoriaArmaDTO = categoriaArmaService.mostrarTodos();
            return ResponseEntity.ok(listaCategoriaArmaDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener la lista");
        }
    }
}
