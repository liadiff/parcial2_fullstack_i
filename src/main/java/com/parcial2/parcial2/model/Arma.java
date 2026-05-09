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
@Table(name = "Armas")

public class Arma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "arma_id")
    private Integer id;

    @NotBlank(message ="El nombre del arma no puede estar vacio!!")
    @Column (name = "nombre", unique = true)
    private String nombre;

    @ManyToOne
    @NotNull(message = "El tipo de arma no puede estar vacio!!")
    @JoinColumn (name = "tipo_arma_id")
    private  TipoArma tipoArma;

    @NotNull(message = "El daño del arma no pude ser nulo!!")
    @Column (name = "daño")
    private Float daño;

    @NotNull(message = "La velocidad del arma no pude ser nula!!")
    @Column (name = "velocidad_arma")
    private Float velocidadArma;

    @OneToMany (mappedBy = "arma")
    private List<Entidad> listaEntidades;



}
