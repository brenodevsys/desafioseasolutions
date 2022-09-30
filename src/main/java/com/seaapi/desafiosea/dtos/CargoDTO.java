package com.seaapi.desafiosea.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO {

    private Long id;
    private String nome;
    private SetorDTO setorDTO;
    private TrabalhadorDTO trabalhadorDTO;
}
