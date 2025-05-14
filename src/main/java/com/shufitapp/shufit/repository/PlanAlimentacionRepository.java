package com.shufitapp.shufit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.PlanAlimentacion;

@Repository
public interface PlanAlimentacionRepository extends JpaRepository<PlanAlimentacion, Integer> {

    List<PlanAlimentacion> findByCliente_IdCliente(Integer clienteId);

    List<PlanAlimentacion> findByFechaFinAfter(LocalDate today);

    List<PlanAlimentacion> findByObjetivoIgnoreCase(String objetivo);

}
