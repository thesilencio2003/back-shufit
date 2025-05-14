package com.shufitapp.shufit.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.HorarioClaseGrupal;

@Repository
public interface HorarioClaseGrupalRepository extends JpaRepository<HorarioClaseGrupal, Integer> {

    List<HorarioClaseGrupal> findByClaseGrupal_IdClase(Integer claseId);

    List<HorarioClaseGrupal> findByDiaSemana(String diaSemana);

    List<HorarioClaseGrupal> findByClaseGrupal_IdClaseAndDiaSemanaAndHoraInicioAndHoraFin(
            Integer claseId, String diaSemana, LocalTime horaInicio, LocalTime horaFin);

}
