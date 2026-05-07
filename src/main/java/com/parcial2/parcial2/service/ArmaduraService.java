package com.parcial2.parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.model.Armadura;
import com.parcial2.parcial2.repository.ArmaduraRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArmaduraService {
    @Autowired
    private ArmaduraRepository armaduraRepository;

    public List<Armadura> listarTodos() {
        return armaduraRepository.findAll();
    }

    public Armadura guardar(Armadura armadura) {
        return armaduraRepository.save(armadura);
    }
}