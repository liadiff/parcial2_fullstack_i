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
@Table (name = "tipo_arma")
public class TipoArma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "tipo_arma_id")
    private Integer id;

    @Column (name = "nombre", unique = true)
    @NotBlank (message = "nombre no puede estar vacio")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "categoria_arma_id", nullable = false)
    @NotNull (message = "Tipo de arma debe tener una categoria")
    private CategoriaArma categoriaArma;

    @OneToMany(mappedBy= "tipoArma")
    private List<Arma> listaArmas;
   
}
