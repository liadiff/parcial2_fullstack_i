package com.parcial2.parcial2.service;

import com.parcial2.parcial2.model.Raza;
import com.parcial2.parcial2.repository.RazaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RazaService {
    @Autowired
    private RazaRepository razaRepository;

    public List<Raza> listarTodos() {
        return razaRepository.findAll();
    }

    public Raza guardar(Raza raza) {
        return razaRepository.save(raza);
    }
}