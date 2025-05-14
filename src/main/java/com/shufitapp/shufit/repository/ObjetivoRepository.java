package com.shufitapp.shufit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Objetivo;

@Repository
public interface ObjetivoRepository extends JpaRepository<Objetivo, Integer> {

    List<Objetivo> findByCliente_IdCliente(Integer clienteId);

    List<Objetivo> findByTipoObjetivoIgnoreCase(String tipoObjetivo);

    List<Objetivo> findByEstadoObjetivoIgnoreCase(String estadoObjetivo);

    List<Objetivo> findByFechaInicioBetween(LocalDate start, LocalDate end);

    List<Objetivo> findByFechaFinBetween(LocalDate start, LocalDate end);

    List<Objetivo> findByCliente_IdClienteAndEstadoObjetivoIgnoreCase(Integer clienteId, String estadoObjetivo);

}
