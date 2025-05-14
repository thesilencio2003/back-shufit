package com.shufitapp.shufit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shufitapp.shufit.Models.HistorialMedico;

public interface HistorialMedicoRepository extends JpaRepository<HistorialMedico, Integer>  {
    Optional<HistorialMedico> findByCliente_IdCliente(Integer clienteId);
    boolean existsByCliente_IdCliente(Integer clienteId);
}
