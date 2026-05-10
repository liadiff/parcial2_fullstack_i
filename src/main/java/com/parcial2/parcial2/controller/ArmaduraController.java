package com.parcial2.parcial2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcial2.parcial2.dto.ArmaduraDTO;
import com.parcial2.parcial2.model.Armadura;
import com.parcial2.parcial2.service.ArmaduraService;

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