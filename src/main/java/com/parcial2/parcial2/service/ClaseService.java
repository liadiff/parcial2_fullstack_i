package com.parcial2.parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.model.Clase;
import com.parcial2.parcial2.repository.ClaseRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClaseService {
    @Autowired
    private ClaseRepository claseRepository;

    public List<Clase> listarTodos() {
        return claseRepository.findAll();
    }

    public Clase guardar(Clase clase) {
        return claseRepository.save(clase);
    }
}