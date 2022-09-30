package com.seaapi.desafiosea.service;

import com.seaapi.desafiosea.model.Cargo;
import com.seaapi.desafiosea.model.Setor;
import com.seaapi.desafiosea.repository.CargoRepository;
import com.seaapi.desafiosea.repository.SetorRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SetorService {
    
    final SetorRepository setorRepository;

    final CargoRepository cargoRepository;
    
    public SetorService(SetorRepository setorRepository, CargoRepository cargoRepository) {
        this.setorRepository = setorRepository;
        this.cargoRepository = cargoRepository;
    }

    @Transactional
    public Setor adicionarSetor(Setor setor){return setorRepository.save(setor);}
    public List<Setor> procurarTodosSetores() {return setorRepository.findAll();}
    public Setor atualizarSetor(Setor setor){return setorRepository.save(setor);}
    public Optional<Setor> procurarSetorPorId(Long id) {
        return setorRepository.findById(id);}
    public void deletarSetor(Setor setor) {setorRepository.delete(setor);}
    public boolean existsById(Long id) {
        return setorRepository.existsById(id);
    }

}
