package com.seaapi.desafiosea.controller;

import com.seaapi.desafiosea.dtos.CargoDTO;
import com.seaapi.desafiosea.dtos.SetorDTO;
import com.seaapi.desafiosea.model.Cargo;
import com.seaapi.desafiosea.model.Setor;
import com.seaapi.desafiosea.repository.CargoRepository;
import com.seaapi.desafiosea.service.CargoService;
import com.seaapi.desafiosea.service.SetorService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/setor")
public class SetorController {

    final SetorService setorService;

    final CargoService cargoService;

    public SetorController(SetorService setorService, CargoService cargoService) {
        this.setorService = setorService;
        this.cargoService = cargoService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarSetor(@RequestBody @Valid SetorDTO setorDTO) {
        if(setorService.existsById(setorDTO.getId())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao cadastrar novo setor: Setor já existente.");
        }
        var novoSetor = new Setor();
        BeanUtils.copyProperties(setorDTO, novoSetor);
        return ResponseEntity.status(HttpStatus.CREATED).body(setorService.adicionarSetor(novoSetor));
    }


    @GetMapping
    public ResponseEntity<List<Setor>> buscarTodosSetores() {
        return ResponseEntity.status(HttpStatus.OK).body(setorService.procurarTodosSetores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarUmSetor(@PathVariable(value = "id") Long id) {
        Optional<Setor> setorOptional = setorService.procurarSetorPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(setorOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarSetor(@PathVariable(value = "id") Long id,
                                                       @RequestBody @Valid SetorDTO setorDTO) {
        Optional<Setor> setorOptional = setorService.procurarSetorPorId(id);
        if (!setorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Setor não encontrado.");
        }
        var setor = setorOptional.get();
        setor.setNome(setorDTO.getNome());
        return ResponseEntity.status(HttpStatus.OK).body(setorService.atualizarSetor(setor));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarSetor(@PathVariable(value = "id") Long id){
        Optional<Setor> setorOptional = setorService.procurarSetorPorId(id);
        if (!setorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Setor não encontrado.");
        }
        setorService.deletarSetor(setorOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Setor excluído com sucesso.");
    }

}
