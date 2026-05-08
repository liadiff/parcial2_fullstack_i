package com.parcial2.parcial2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Arenas")
public class Arena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "arena_id")
    private Integer id;

    @NotBlank(message = "El nombre de la arena no puede estar vacio!")
    @Size(min = 3, max = 80, message = "El nombre de la arena debe tener entre 3 y 80 caracteres")
    @Column(nullable = false, length = 80, unique = true)
    private String nombre;

    @NotNull(message = "El multiplicador de daño no puede estar vacio!")
    @Min(value = 0, message = "El valor minimo para el multiplicador de velocidad es 0")
    @Max(value = 5, message = "El valor maximo para el multiplicador de velocidad es 5")
    @Column(nullable = false)
    private Float multiplicadorDeVelocidad;

    @NotNull(message = "El multiplicador de HP no puede estar vacio!")
    @Min(value = 0, message = "El valor minimo para el multiplicador de HP es 0")
    @Max(value = 5, message = "El valor maximo para el multiplicador de HP es 5")
    @Column(nullable = false)
    private Float multiplicadorDeHP;

}