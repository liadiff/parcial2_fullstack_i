package com.parcial2.parcial2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArmaDTO {
    private Integer id;
    private String nombre;
    private Float daño;
    private Float velocidadArma;
    private String tipoArmaNombre; 
}