package com.seaapi.desafiosea.dtos;

import com.seaapi.desafiosea.model.Cargo;
import com.seaapi.desafiosea.model.Setor;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrabalhadorDTO {

    private Long id;
    private String nome;
    private String cpf;
    private SetorDTO setorDTO;
    private CargoDTO cargoDTO;

}
