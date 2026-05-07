package com.parcial2.parcial2.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Armadura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "armadura_id", nullable = false)
    private Integer id;

    @NotBlank(message = "El nombre de la armadura no puede estar vacio!!")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotNull(message = "El hp de la armadura no puede ser nulo!!")
    @Column(name= "hp", nullable = false , length = 50)
    private Float hp;

    @NotNull(message = "La proteccion de la armadura no puede ser nula!!")
    @Column(name = "proteccion", nullable = false, length = 50)
    private Float proteccion;

    @OneToMany (mappedBy = "armadura")
    private List<Entidad> listaEntidades;

}