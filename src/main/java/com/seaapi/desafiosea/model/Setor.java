package com.seaapi.desafiosea.model;

import com.seaapi.desafiosea.service.TrabalhadorService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name ="tb_setor")
public class Setor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "setor")
    private List<Cargo> cargos = new ArrayList<>();

    @OneToOne(mappedBy = "setor")
    private Trabalhador trabalhador;


}
