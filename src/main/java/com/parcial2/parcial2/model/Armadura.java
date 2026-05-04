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

    @NotNull(message = "La durabilidad de la armadura no puede ser nula!!")
    private Double durabilidad;

    @NotBlank(message = "El nombre de la armadura no puede estar vacio!!")
    private String nombre;

    @NotBlank(message = "El tipo de armadura no puede estar vacio!!")
    private String tipoArmadura;
    
}