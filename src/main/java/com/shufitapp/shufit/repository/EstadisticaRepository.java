package com.shufitapp.shufit.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Estadistica;

@Repository
public interface EstadisticaRepository extends JpaRepository<Estadistica, Integer> {

     List<Estadistica> findByFechaCalculoBetween(LocalDateTime start, LocalDateTime end);
    Estadistica findTopByOrderByFechaCalculoDesc();

}
