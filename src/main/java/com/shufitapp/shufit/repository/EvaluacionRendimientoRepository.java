package com.shufitapp.shufit.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.controller.EvaluacionRendimiento;

@Repository
public interface EvaluacionRendimientoRepository extends JpaRepository<EvaluacionRendimiento, Integer>{

     List<EvaluacionRendimiento> findByCliente_IdClienteOrderByFechaEvaluacionDesc(Integer clienteId);
    List<EvaluacionRendimiento> findByFechaEvaluacionBetween(LocalDateTime start, LocalDateTime end);

}
