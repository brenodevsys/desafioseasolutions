package com.seaapi.desafiosea.repository;

import com.seaapi.desafiosea.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    boolean existsById(Long id);
    Cargo findCargoByNome(String nome);
}
