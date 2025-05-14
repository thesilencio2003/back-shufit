package com.shufitapp.shufit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Nutricionista;

@Repository
public interface NutricionistaRepository extends JpaRepository<Nutricionista, Integer> {
    Optional<Nutricionista> findByPersona_IdPersona(Integer personaId);
    boolean existsByPersona_IdPersona(Integer personaId);
    boolean existsByCedulaProfesional(String cedulaProfesional);
}
