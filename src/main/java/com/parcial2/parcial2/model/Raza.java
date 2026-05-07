package com.parcial2.parcial2.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "raza")
public class Raza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raza_id", nullable = false)
    private Integer id;

    @NotBlank(message = "El nombre de la raza no puede estar vacio!!")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "La descripcion de la raza no puede estar vacio!!")
    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @OneToMany (mappedBy = "raza")
    private List<Entidad> listaEntidades;
}