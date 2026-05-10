package com.parcial2.parcial2.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "batallas")
public class Batalla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batalla_id")
    private Integer id;

    @NotBlank(message = "El estado de la batalla no puede estar vacio!")
    @Column(nullable = false)
    private Boolean finalizado;

    @ManyToOne
    @JoinColumn(name = "arena_id", nullable = false)
    private Arena arena;

    @OneToMany(mappedBy = "batalla") // "batalla" es el nombre del atributo en la clase Partida
    private List<Partida> partidas;
}
