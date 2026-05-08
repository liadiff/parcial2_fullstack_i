package com.parcial2.parcial2.dto;

import com.parcial2.parcial2.model.Arena;

import lombok.Data;

@Data
public class BatallaDTO {
    private Integer id;
    private Boolean finalizado;
    private Arena arena;
}
