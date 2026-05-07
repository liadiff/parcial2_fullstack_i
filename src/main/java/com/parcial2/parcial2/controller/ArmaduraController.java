package com.parcial2.parcial2.controller;

import com.parcial2.parcial2.model.Armadura;
import com.parcial2.parcial2.dto.ArmaduraDTO;
import com.parcial2.parcial2.service.ArmaduraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/armadura")
public class ArmaduraController {

    @Autowired
    private ArmaduraService armaduraService;

    @GetMapping("/listar")
    public List<Armadura> listar() {
        return armaduraService.listarTodos();
    }

    @PostMapping("/guardar")
    public Armadura guardar(@RequestBody ArmaduraDTO dto) {
        Armadura a = new Armadura();
        a.setNombre(dto.getNombre());
        a.setHp(dto.getPuntosVida());
        a.setProteccion(dto.getProteccion());
        return armaduraService.guardar(a);
    }
}