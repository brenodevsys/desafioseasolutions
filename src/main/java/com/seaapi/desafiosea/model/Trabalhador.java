package com.seaapi.desafiosea.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name ="tb_trabalhador")
public class Trabalhador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @OneToOne()
    @JoinColumn(name = "setor_id")
    private Setor setor;

    @OneToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

}
