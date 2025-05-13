package com.shufitapp.shufit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Entrenador;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer> {

    Optional<Entrenador> findByPersona_IdPersona(Integer personaId);

    boolean existsByPersona_IdPersona(Integer personaId);
}
