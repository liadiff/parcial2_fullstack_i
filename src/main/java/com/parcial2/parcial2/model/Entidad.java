package com.parcial2.parcial2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    private Boolean jugable; //True = jugador - False = npc
    
    //FK
    @ManyToOne
    @JoinColumn (name = "tipo_arma_id")
    private Arma arma;
    //FK
    @ManyToOne
    @JoinColumn (name = "raza_id")
    private  Raza raza;
    //FK
    @ManyToOne
    @JoinColumn (name = "clase_id")
    private Clase clase;
    //FK
    @ManyToOne
    @JoinColumn (name = "armadura_id")
    private Armadura armadura;
}
