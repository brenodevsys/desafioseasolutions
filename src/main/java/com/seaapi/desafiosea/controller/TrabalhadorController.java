package com.seaapi.desafiosea.controller;

import com.seaapi.desafiosea.dtos.TrabalhadorDTO;
import com.seaapi.desafiosea.model.Trabalhador;
import com.seaapi.desafiosea.service.TrabalhadorService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/trabalhador")
public class TrabalhadorController {
    final TrabalhadorService trabalhadorService;

    public TrabalhadorController(TrabalhadorService trabalhadorService) {
        this.trabalhadorService = trabalhadorService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarTrabalhador(@RequestBody @Valid TrabalhadorDTO trabalhadorDTO) {
        if(trabalhadorService.existsTrabalhadorByCpf(trabalhadorDTO.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao cadastrar novo trabalhador: CPF já existente.");
        }
        var novoTrabalhador = new Trabalhador();
        BeanUtils.copyProperties(trabalhadorDTO, novoTrabalhador);
        return ResponseEntity.status(HttpStatus.CREATED).body(trabalhadorService.adicionarTrabalhor(novoTrabalhador));
    }

    @GetMapping
    public ResponseEntity<List<Trabalhador>> buscarTodosTrabalhadores() {
        return ResponseEntity.status(HttpStatus.OK).body(trabalhadorService.procurarTodosTrabalhadores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarUmTrabalhador(@PathVariable(value = "id") Long id) {
        Optional<Trabalhador> trabalhadorOptional = trabalhadorService.procurarTrabalhadorPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(trabalhadorOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarTrabalhador(@PathVariable(value = "id") Long id,
                                                       @RequestBody @Valid TrabalhadorDTO trabalhadorDTO) {
        Optional<Trabalhador> trabalhadorOptional = trabalhadorService.procurarTrabalhadorPorId(id);
        if (!trabalhadorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Trabalhador não encontrado.");
        }
        var trabalhador = trabalhadorOptional.get();
        trabalhador.setNome(trabalhadorDTO.getNome());
        trabalhador.setCpf(trabalhadorDTO.getCpf());
        return ResponseEntity.status(HttpStatus.OK).body(trabalhadorService.atualizarTrabalhador(trabalhador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarTrabalhador(@PathVariable(value = "id") Long id){
        Optional<Trabalhador> trabalhadorOptional = trabalhadorService.procurarTrabalhadorPorId(id);
        if (!trabalhadorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Trabalhador não encontrado.");
        }
        trabalhadorService.deletarTrabalhador(trabalhadorOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Trabalhador excluido com sucesso.");
    }


}
