package com.parcial2.parcial2.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Partidas")
public class Partida {
    
    
    private Entidad jugador;

    private Entidad enemigo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre de la partida no puede estar vacio!!")
    private String nombre;

    @NotBlank(message = "La descripcion de la partida no puede estar vacia!!")
    private String descripcion;
}