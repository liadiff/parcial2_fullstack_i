package com.parcial2.parcial2.dto;

import lombok.Data;

@Data
public class ArmaDTO { //Ver como los paso AL DTO
    private Integer id;
    private String nombre;
    private Float daño;
    private Float velocidadArma;
    private String tipoArmaNombre; 
}