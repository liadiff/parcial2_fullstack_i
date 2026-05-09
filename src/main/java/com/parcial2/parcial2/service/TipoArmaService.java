package com.parcial2.parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.model.TipoArma;
import com.parcial2.parcial2.repository.TipoArmaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoArmaService {

    @Autowired
    TipoArmaRepository tipoArmaRepository;
    //Agregar

    public TipoArma agregarTipoArma (TipoArma tipoArma){
        if(tipoArmaRepository.existsByNombre(tipoArma.getNombre())){
            throw new RuntimeException("Ese tipo de arma ya existe en la base de datos");
        }
        return tipoArmaRepository.save(tipoArma);
    }
    //Eliminar

    public String eliminarTipoArma(Integer id){
        TipoArma tipoArmaEncontrada = tipoArmaRepository.findById(id).orElseThrow(() -> new RuntimeException("El tipo de arma con ID " + id + " no existe"));
        tipoArmaRepository.delete(tipoArmaEncontrada);
        return "la categoria " + tipoArmaEncontrada.getNombre() + "ha sido eliminada";
    }
    //Modificar

    public TipoArma modificarTipoArma(Integer id, TipoArma nuevoTipoArma){
        TipoArma tipoArmaEncontrada = tipoArmaRepository.findById(id).orElseThrow(() -> new RuntimeException("El tipo de arma con ID " + id + " no existe"));
        tipoArmaEncontrada.setCategoriaArma(nuevoTipoArma.getCategoriaArma());
        tipoArmaEncontrada.setNombre(nuevoTipoArma.getNombre());
        tipoArmaRepository.save(tipoArmaEncontrada);
        return tipoArmaEncontrada;
    }

    //Buscar

    public TipoArma buscarTipoArma(Integer id){
        TipoArma tipoArmaEncontrada = tipoArmaRepository.findById(id).orElseThrow(() -> new RuntimeException("El tipo de arma con ID " + id + " no existe"));
        return tipoArmaEncontrada;
    }
    //Mostrar todos

    public List<TipoArma> listaTipoArma(){
        List<TipoArma> listaTipoArma = tipoArmaRepository.findAll();
        return listaTipoArma;
    }
}
