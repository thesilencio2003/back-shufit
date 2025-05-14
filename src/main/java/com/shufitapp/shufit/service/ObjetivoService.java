package com.shufitapp.shufit.service;

import java.time.LocalDate;
import java.util.List;

import com.shufitapp.shufit.dto.ObjetivoDTO;

public interface ObjetivoService {
    List<ObjetivoDTO> findAll();

    ObjetivoDTO findById(Integer id);

    ObjetivoDTO save(ObjetivoDTO dto);

    ObjetivoDTO update(Integer id, ObjetivoDTO dto);

    void deleteById(Integer id);

    List<ObjetivoDTO> findByClientId(Integer clienteId);

    List<ObjetivoDTO> findByType(String tipoObjetivo);

    List<ObjetivoDTO> findByStatus(String estadoObjetivo);

    List<ObjetivoDTO> findByStartDateBetween(LocalDate start, LocalDate end);

    List<ObjetivoDTO> findByEndDateBetween(LocalDate start, LocalDate end);

    List<ObjetivoDTO> findActiveByClientId(Integer clienteId);

    ObjetivoDTO updateProgress(Integer id, Double progreso);

    ObjetivoDTO updateStatus(Integer id, String estadoObjetivo);
}
