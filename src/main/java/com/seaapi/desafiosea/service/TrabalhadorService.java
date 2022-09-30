package com.seaapi.desafiosea.service;

import com.seaapi.desafiosea.model.Trabalhador;
import com.seaapi.desafiosea.repository.TrabalhadorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TrabalhadorService {
    final TrabalhadorRepository trabalhadorRepository;

    public TrabalhadorService(TrabalhadorRepository trabalhadorRepository) {
        this.trabalhadorRepository = trabalhadorRepository;
    }

    @Transactional
    public Trabalhador adicionarTrabalhor(Trabalhador trabalhador){
        return trabalhadorRepository.save(trabalhador);
    }
    
    public List<Trabalhador> procurarTodosTrabalhadores() {return trabalhadorRepository.findAll();}

    public Trabalhador atualizarTrabalhador(Trabalhador trabalhador){
        return trabalhadorRepository.save(trabalhador);
    }

    public Optional<Trabalhador> procurarTrabalhadorPorId(Long id) {
        return trabalhadorRepository.findById(id);
    }

    public void deletarTrabalhador(Trabalhador trabalhador) {
        trabalhadorRepository.delete(trabalhador);
    }

    public boolean existsTrabalhadorByCpf(String cpf) {
        return trabalhadorRepository.existsTrabalhadorByCpf(cpf);
    }
}
