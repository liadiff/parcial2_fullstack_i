package com.parcial2.parcial2.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "Armas")
public class Arma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message ="El nombre del arma no puede estar vacio!!")
    private String nombre;

    @NotBlank(message = "El tipo de arma no puede estar vacio!!")
    private  String tipoArma;

    @NotNull(message = "El daño del arma no pude ser nulo!!")
    private Double  daño;

    @NotNull(message = "La velocidad del arma no pude ser nula!!")
    private Double  VelocidadArma;



}
