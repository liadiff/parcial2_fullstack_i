package com.parcial2.parcial2.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "clases")
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "clase_id")
    private Integer id;

    @NotBlank(message = "El nombre de la clase no puede estar vacio!!")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;


    @NotNull
    @Column(name= "mult_dano", nullable = false)
    private Float mult_dano;

    @NotNull
    @Column(name= "mult_veloc_ataque", nullable = false)
    private Float mult_veloc_ataque;


    @NotNull
    @Column(name= "mult_hp", nullable = false)
    private Float mult_hp;

    @NotBlank(message = "La descripcion de la clase no puede estar vacia!!")
    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @OneToMany (mappedBy = "clase")
    private List<Entidad> listaEntidades;


}
