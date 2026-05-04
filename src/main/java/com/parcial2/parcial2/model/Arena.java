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
public class Arena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El multiplicador de daño no puede estar vacio!!")
    private Float multiplicadorDeVelocidad;

    @NotBlank(message = "El nombre de la arena no puede estar vacio!!")
    private String nombre;

    @NotNull(message = "El multiplicador de HP no puede estar vacio!!")
    private Float multiplicadorDeHP;

}