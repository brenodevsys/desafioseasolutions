package com.seaapi.desafiosea.service;

import com.seaapi.desafiosea.model.Cargo;
import com.seaapi.desafiosea.repository.CargoRepository;
import com.seaapi.desafiosea.repository.SetorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    final CargoRepository cargoRepository;

    final SetorRepository setorRepository;

    public CargoService(CargoRepository cargoRepository, SetorRepository setorRepository) {
        this.cargoRepository = cargoRepository;
        this.setorRepository = setorRepository;
    }

    @Transactional
    public Cargo adicionarCargo(Long id, Cargo cargo) {
        var setor = setorRepository.findSetorById(id);
        cargo.setSetor(setorRepository.findSetorById(id));
        return cargoRepository.save(cargo);}

    @Transactional
    public List<Cargo> procurarTodosCargos() {
        setorRepository.findAll();
        return cargoRepository.findAll();
    }

    public Cargo atualizarCargo(Cargo cargo){
        return cargoRepository.save(cargo);
    }

    public Optional<Cargo> procurarCargoPorId(Long id) {
        return cargoRepository.findById(id);
    }

    public void deletarCargo(Cargo cargo) {
        cargoRepository.delete(cargo);
    }

    public boolean existsById(Long id) {
        return cargoRepository.existsById(id);
    }


}
