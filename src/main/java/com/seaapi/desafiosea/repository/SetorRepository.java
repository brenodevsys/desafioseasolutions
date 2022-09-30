package com.seaapi.desafiosea.repository;

import com.seaapi.desafiosea.model.Cargo;
import com.seaapi.desafiosea.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {
    boolean existsById(Long id);
    Setor findSetorById(Long id);

}
