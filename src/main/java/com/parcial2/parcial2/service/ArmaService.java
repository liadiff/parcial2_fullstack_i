package com.parcial2.parcial2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.dto.ArmaDTO;
import com.parcial2.parcial2.model.Arma;
import com.parcial2.parcial2.repository.ArmaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ArmaService {

    //Repositorios

    @Autowired
    private ArmaRepository armaRepository;

    //Agregar
    
    public Arma agregarArma(Arma arma){
        if(armaRepository.existsByNombre(arma.getNombre())){
            throw new RuntimeException("Esa arma ya existe en la base de datos");
        }
        return armaRepository.save(arma);
    }

    //Eliminar

    public String eliminarArma (Integer id){
       Arma armaEncontrada = armaRepository.findById(id).orElseThrow(() -> new RuntimeException("El arma con ID " + id + " no existe"));
       armaRepository.delete(armaEncontrada);

       return armaEncontrada.getNombre() + "ha sido eliminada exitosamente";
    }

    //Modificar

    public Arma modificarArma (Arma armaNueva, Integer id){
        Arma armaEncontrada = armaRepository.findById(id).orElseThrow(() -> new RuntimeException("El arma con ID " + id + " no existe"));
        armaEncontrada.setDaño(armaNueva.getDaño());
        armaEncontrada.setNombre(armaNueva.getNombre());
        armaEncontrada.setVelocidadArma(armaNueva.getVelocidadArma());
        armaEncontrada.setTipoArma(armaNueva.getTipoArma());
        armaRepository.save(armaEncontrada);
        return armaEncontrada;
    }

    //Buscar

    public ArmaDTO encontrarArma (Integer id){
        Arma armaEncontrada = armaRepository.findById(id).orElseThrow(() -> new RuntimeException("El arma con ID " + id + " no existe"));
        return convertirADTO(armaEncontrada);
    }
    //Mostrar todos

    public List<ArmaDTO> mostrarTodas(){
        List<Arma> listaDeArmas = armaRepository.findAll();

        List<ArmaDTO> listaDeArmasDTO = new ArrayList<>();

        for(Arma arma : listaDeArmas){
            listaDeArmasDTO.add(convertirADTO(arma));
        }
        return listaDeArmasDTO;
    }

     //Convertir a DTO

    public ArmaDTO convertirADTO (Arma arma){
        ArmaDTO nuevaArmaDTO = new ArmaDTO();
        nuevaArmaDTO.setDaño(arma.getDaño());
        nuevaArmaDTO.setId(arma.getId());
        nuevaArmaDTO.setNombre(arma.getNombre());
        nuevaArmaDTO.setTipoArmaNombre(arma.getTipoArma().getNombre());
        nuevaArmaDTO.setVelocidadArma(arma.getVelocidadArma());
        return nuevaArmaDTO;
    }
}
