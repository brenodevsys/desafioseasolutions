package com.seaapi.desafiosea.repository;

import com.seaapi.desafiosea.model.Trabalhador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Long> {
    boolean existsTrabalhadorByCpf(String cpf);

}
