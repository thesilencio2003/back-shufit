package com.shufitapp.shufit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Recepcionista;

@Repository
public interface RecepcionistaRepository extends JpaRepository<Recepcionista, Integer> {

    Optional<Recepcionista> findByPersona_IdPersona(Integer personaId);

    boolean existsByPersona_IdPersona(Integer personaId);

}
