package com.seaapi.desafiosea.controller;

import com.seaapi.desafiosea.dtos.CargoDTO;
import com.seaapi.desafiosea.model.Cargo;
import com.seaapi.desafiosea.repository.CargoRepository;
import com.seaapi.desafiosea.service.CargoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value ="/cargo")
public class CargoController {

   final CargoService cargoService;

   final CargoRepository cargoRepository;

    public CargoController(CargoService cargoService, CargoRepository cargoRepository) {
        this.cargoService = cargoService;
        this.cargoRepository = cargoRepository;
    }

    @PostMapping("/setor/{id}")
    public ResponseEntity<Object> salvarCargo(@PathVariable(value = "id") Long id,
                                              @RequestBody @Valid CargoDTO cargoDTO) {
        if(Objects.nonNull(cargoRepository.findCargoByNome(cargoDTO.getNome()))){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao cadastrar novo cargo: Cargo já existente.");
        }
        var novoCargo = new Cargo();
        BeanUtils.copyProperties(cargoDTO, novoCargo);
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.adicionarCargo(id, novoCargo));
    }


    @GetMapping
    public ResponseEntity<List<Cargo>> buscarTodosCargos() {
        return ResponseEntity.status(HttpStatus.OK).body(cargoService.procurarTodosCargos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarUmCargo(@PathVariable(value = "id") Long id) {
        Optional<Cargo> cargoOptional = cargoService.procurarCargoPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(cargoOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCargo(@PathVariable(value = "id") Long id,
                                                 @RequestBody @Valid CargoDTO cargoDTO) {
        Optional<Cargo> cargoOptional = cargoService.procurarCargoPorId(id);
        if (!cargoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cargo não encontrado.");
        }
        var cargo = cargoOptional.get();
        cargo.setNome(cargoDTO.getNome());
        return ResponseEntity.status(HttpStatus.OK).body(cargoService.adicionarCargo(id, cargo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCargo(@PathVariable(value = "id") Long id){
        Optional<Cargo> cargoOptional = cargoService.procurarCargoPorId(id);
        if (!cargoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cargo não encontrado.");
        }
        cargoService.deletarCargo(cargoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cargo excluído com sucesso.");
    }

}
