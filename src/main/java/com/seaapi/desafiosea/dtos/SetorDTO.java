package com.seaapi.desafiosea.dtos;

import com.seaapi.desafiosea.model.Cargo;
import com.seaapi.desafiosea.model.Trabalhador;
import lombok.*;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetorDTO {

    private Long id;
    private String nome;
    private List<CargoDTO> cargosDTO;
    private TrabalhadorDTO trabalhadorDTO;
}
