package com.parcial2.parcial2.controller;

import com.parcial2.parcial2.model.Clase;
import com.parcial2.parcial2.dto.ClaseDTO;
import com.parcial2.parcial2.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clase")
public class ClaseController {
    @Autowired
    private ClaseService claseService;

    @GetMapping("/listar")
    public List<ClaseDTO> listar() { 
        return claseService.listarTodos(); 
    }

    @PostMapping("/guardar")
    public ClaseDTO guardar(@RequestBody ClaseDTO dto) {
        Clase c = new Clase();
        c.setNombre(dto.getNombre());
        c.setDescripcion(dto.getDescripcion());
        c.setMult_dano(dto.getMultDano());
        // Agrega aquí los otros setters si tu DTO tiene más campos
        
        return claseService.guardar(c);
    }
}