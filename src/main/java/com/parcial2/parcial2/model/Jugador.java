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
@Table(name = "jugadores")
public class Jugador {
    private Arma arma;

    public Jugador(Arma arma){
        this.arma = arma;
    }

    private Partida partida;{
        this.partida = partida;
    }

    private Categoria categoria;{
        this.categoria = categoria;
    }

    private  Raza raza;{
        this.raza = raza;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre del jugador no puede estar vacio!!")
    private String nombre;

    @NotBlank(message = "La clase deljugador no puede estar vacia")
    private String clase;

    @NotNull(message = "El nivel del jugador debe ser minimo 1 ")
    private Integer nivel;

    @NotBlank(message = "La raza del jugador no puede estar vacia")
    private String raza;

}
