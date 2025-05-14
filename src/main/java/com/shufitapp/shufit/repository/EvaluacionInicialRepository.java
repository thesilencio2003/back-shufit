package com.shufitapp.shufit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.EvaluacionInicial;

@Repository
public interface EvaluacionInicialRepository extends JpaRepository<EvaluacionInicial, Integer> {

    Optional<EvaluacionInicial> findByCliente_IdCliente(Integer clienteId);

    boolean existsByCliente_IdCliente(Integer clienteId);

}
