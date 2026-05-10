package com.parcial2.parcial2.controller;

import java.util.List;

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

import com.parcial2.parcial2.dto.TipoArmaDTO;
import com.parcial2.parcial2.model.TipoArma;
import com.parcial2.parcial2.service.TipoArmaService;

@Controller
@RequestMapping("/api/v1/tipoArmas")
public class TipoArmaController {

    @Autowired
    private TipoArmaService tipoArmaService;

    //Agregar
    @PostMapping("/agregarTipoArma")
    public ResponseEntity<?> agregarTipoArma(@RequestBody TipoArma tipoArma) {
        try {
            TipoArma TipoArmaNuevo = tipoArmaService.agregarTipoArma(tipoArma);
            return ResponseEntity.status(HttpStatus.CREATED).body(tipoArmaService.convertirTipoArmaDTO(TipoArmaNuevo));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    //Eliminar
    @DeleteMapping("/eliminarTipoArma/{id}")
    public ResponseEntity<?> eliminarTipoArma(@PathVariable Integer id) {
        try {
            String mensaje = tipoArmaService.eliminarTipoArma(id);
            return ResponseEntity.ok(mensaje);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    //Modificar
    @PutMapping("/modificarTipoArma/{id}")
    public ResponseEntity<?> modificarTipoArma(@PathVariable Integer id, @RequestBody TipoArma tipoArma){
        try {
            TipoArmaDTO tipoArmaDTO = tipoArmaService.modificarTipoArma(id, tipoArma);
            return ResponseEntity.ok(tipoArmaDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    //Buscar
    @GetMapping("/buscarTipoArma/{id}")
    public ResponseEntity<?> buscarTipoArma(@PathVariable Integer id){
        try {
            TipoArmaDTO tipoArmaDTO = tipoArmaService.buscarTipoArma(id);
            return ResponseEntity.ok(tipoArmaDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    //Buscar todos
    @GetMapping("/mostrarTipoArmas")
    public ResponseEntity<?> mostrarTipoArmas(){
        try {
            List<TipoArmaDTO> lista = tipoArmaService.listaTipoArma();
            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud");
        }
    }
}
