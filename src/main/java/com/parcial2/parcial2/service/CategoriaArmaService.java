package com.parcial2.parcial2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcial2.parcial2.dto.CategoriaArmaDTO;
import com.parcial2.parcial2.model.CategoriaArma;
import com.parcial2.parcial2.repository.CategoriaArmaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaArmaService {

    @Autowired
    private CategoriaArmaRepository categoriaArmaRepository;

    //Agregar

    public CategoriaArma agregarCategoriaArma (CategoriaArma categoriaNueva){
        if(categoriaArmaRepository.existsByNombre(categoriaNueva.getNombre())){
            throw new RuntimeException("Esa categoria ya existe en la base de datos");
        }
        return categoriaArmaRepository.save(categoriaNueva);
    }

    //Eliminar

    public String eliminarCategoria (Integer id){ //Quizas sea mejor un booleano
        CategoriaArma categoriaEncontrada = categoriaArmaRepository.findById(id).orElseThrow(() -> new RuntimeException("La categoria con ID " + id + " no existe"));
        categoriaArmaRepository.delete(categoriaEncontrada);
        return "La categoria " + categoriaEncontrada.getNombre() + " ha sido eliminada"; //Verificar como va a funcionar la eliminacion en casacada
    }
    //Modificar

    public CategoriaArma modificarCategoria (Integer id, CategoriaArma nuevaCategoria){
        CategoriaArma categoriaEncontrada = categoriaArmaRepository.findById(id).orElseThrow(() -> new RuntimeException("La categoria con ID " + id + " no existe"));
        categoriaEncontrada.setNombre(nuevaCategoria.getNombre());     
        categoriaArmaRepository.save(categoriaEncontrada);
        return categoriaEncontrada;
    }

    //Buscar

    public CategoriaArma encontrarCategoria (Integer id){
        CategoriaArma categoriaEncontrada = categoriaArmaRepository.findById(id).orElseThrow(() -> new RuntimeException("La categoria con ID " + id + " no existe"));
        return categoriaEncontrada;
    }
    //Mostrar todos

    public List<CategoriaArmaDTO> mostrarTodos(){
        List<CategoriaArma> listaCategorias = categoriaArmaRepository.findAll();
        List<CategoriaArmaDTO> listaCategoriasDTO = new ArrayList<>();
        for(CategoriaArma categoriaArma : listaCategorias){
            listaCategoriasDTO.add(convertirCategoriaArmaDTO(categoriaArma));
        }
        return listaCategoriasDTO;
    }

    //Convertir a DTO

    public CategoriaArmaDTO convertirCategoriaArmaDTO (CategoriaArma categoriaArma){
        CategoriaArmaDTO nuevaCategoria = new CategoriaArmaDTO();
        nuevaCategoria.setId(categoriaArma.getId());
        nuevaCategoria.setNombre(categoriaArma.getNombre());
        return nuevaCategoria;
    }

    
}
