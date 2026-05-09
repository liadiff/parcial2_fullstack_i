<<<<<<< Updated upstream
package com.parcial2.parcial2.controller;

import com.parcial2.parcial2.model.Raza;
import com.parcial2.parcial2.dto.RazaDTO;
import com.parcial2.parcial2.service.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/raza")
public class RazaController {
    @Autowired
    private RazaService razaService;

    @GetMapping("/listar")
    public List<Raza> listar() { return razaService.listarTodos(); }

    @PostMapping("/guardar")
    public Raza guardar(@RequestBody RazaDTO dto) {
        Raza r = new Raza();
        r.setNombre(dto.getNombre());
        r.setDescripcion(dto.getDescripcion());
        return razaService.guardar(r);
    }
=======
package com.parcial2.parcial2.controller;

import com.parcial2.parcial2.model.Raza;
import com.parcial2.parcial2.dto.RazaDTO;
import com.parcial2.parcial2.service.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/raza")
public class RazaController {
    @Autowired
    private RazaService razaService;

    @GetMapping("/listar")
    // Cambiamos List<Raza> por List<RazaDTO>
    public List<RazaDTO> listar() { 
        return razaService.listarTodos(); 
    }

    @PostMapping("/guardar")
    // Cambiamos el tipo de retorno de Raza a RazaDTO
    public RazaDTO guardar(@RequestBody RazaDTO dto) {
        Raza r = new Raza();
        r.setNombre(dto.getNombre());
        r.setDescripcion(dto.getDescripcion());
        
        // razaService.guardar(r) ahora devuelve un RazaDTO
        return razaService.guardar(r);
    }
>>>>>>> Stashed changes
}