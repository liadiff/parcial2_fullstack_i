package com.parcial2.parcial2.dto;

import com.parcial2.parcial2.model.Batalla;
import com.parcial2.parcial2.model.Entidad;

import lombok.Data;

@Data
public class PartidaDTO {
    private Integer id;
    private Entidad jugador;
    private Batalla batalla;
    private Entidad enemigo;
}
