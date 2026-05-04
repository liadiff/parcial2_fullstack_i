package com.parcial2.parcial2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "entidades")
public class Entidad {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre del jugador no puede estar vacio!!")
    private String nombre;

    @NotNull(message = "El nivel del jugador debe ser minimo 1 ")
    private Integer nivel;

    private Boolean jugable; //True = jugador - False = npc
    
    //FK
    private Arma arma;
    //FK
    private  Raza raza;
    //FK
    @NotBlank(message = "La clase deljugador no puede estar vacia")
    private Clase clase;
    //FK
    private Armadura armadura;

}
