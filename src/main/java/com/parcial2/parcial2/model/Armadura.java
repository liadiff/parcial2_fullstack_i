package com.parcial2.parcial2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Integer id;

    @NotBlank(message = "El nombre de la armadura no puede estar vacio!!")
    private String nombre;

    @NotNull(message = "El hp de la armadura no puede ser nulo!!")
    private Float hp;

    @NotNull(message = "La proteccion de la armadura no puede ser nula!!")
    private Float proteccion;
    
}

