package com.parcial2.parcial2.model;

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
@Table(name = "entidades")
public class Entidad {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre del jugador no puede estar vacio!!")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotNull(message = "El nivel del jugador debe ser minimo 1 ")
    @Column(name = "nivel", nullable = false)
    private Integer nivel;

    private Boolean jugable; //True = jugador - False = npc
    
    //FK
    @OneToMany
    private Arma arma;
    //FK
    @OneToMany
    private  Raza raza;
    //FK
    @NotBlank(message = "La clase deljugador no puede estar vacia")
    @OneToMany
    private Clase clase;
    //FK
    @OneToMany
    private Armadura armadura;
}
