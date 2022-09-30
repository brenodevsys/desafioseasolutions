package com.seaapi.desafiosea.service;

import com.seaapi.desafiosea.model.Cargo;
import com.seaapi.desafiosea.model.Setor;
import com.seaapi.desafiosea.model.Trabalhador;
import com.seaapi.desafiosea.repository.TrabalhadorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TrabalhadorServiceTest {
    public static final Long ID = 1L;
    public static final String NOME = "Breno Delgado";
    public static final String CPF = "00000000000";
    public static final Setor SETOR = new Setor();
    public static final Cargo CARGO = new Cargo();

    @InjectMocks
    TrabalhadorService service;

    @Mock
    TrabalhadorRepository repository;

    @Test
    @DisplayName("Deve salvar novo trabalhador.")
    void adicionarTrabalhor() {


        List<Cargo> cargos = new ArrayList<>();
        Trabalhador trabalhador = new Trabalhador();

        SETOR.setNome(NOME);
        SETOR.setId(ID);
        SETOR.setCargos(cargos);
        SETOR.setTrabalhador(trabalhador);

        trabalhador.setId(ID);
        trabalhador.setNome(NOME);
        trabalhador.setCpf(CPF);
        trabalhador.setCargo(CARGO);
        trabalhador.setSetor(SETOR);

        CARGO.setTrabalhador(trabalhador);
        CARGO.setNome(NOME);
        CARGO.setId(ID);

        service.adicionarTrabalhor(trabalhador);

        List<Trabalhador> listaTrabalhadores = new ArrayList<>();
        listaTrabalhadores.add(trabalhador);
        Assertions.assertEquals(1, listaTrabalhadores.size());

    }
}