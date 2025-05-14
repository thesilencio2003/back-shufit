package com.shufitapp.shufit.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

    List<Cita> findByCliente_IdCliente(Integer clienteId);
    List<Cita> findByEntrenador_IdEntrenador(Integer entrenadorId);
    List<Cita> findByNutricionista_IdNutricionista(Integer nutricionistaId);
    List<Cita> findByFechaHoraBetween(LocalDateTime start, LocalDateTime end);
    List<Cita> findByTipoCita(String tipoCita);
    List<Cita> findByEstadoCita(String estadoCita);

}
