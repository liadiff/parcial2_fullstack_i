package com.parcial2.parcial2.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "partidas")
public class Partida {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partida_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Entidad jugador;

    @ManyToOne
    @JoinColumn(name = "batalla_id")
    private Batalla batalla;

    @ManyToOne
    @JoinColumn(name = "enemigo_id")
    private Entidad enemigo;
}