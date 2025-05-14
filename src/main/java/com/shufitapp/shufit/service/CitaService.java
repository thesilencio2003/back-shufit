package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;

import com.shufitapp.shufit.dto.CitaDTO;

public interface CitaService {
    List<CitaDTO> findAll();
    CitaDTO findById(Integer id);
    CitaDTO save(CitaDTO dto);
    CitaDTO update(Integer id, CitaDTO dto);
    void deleteById(Integer id);
    List<CitaDTO> findByClienteId(Integer clienteId);
    List<CitaDTO> findByEntrenadorId(Integer entrenadorId);
    List<CitaDTO> findByNutricionistaId(Integer nutricionistaId);
    List<CitaDTO> findByFechaHoraBetween(LocalDateTime start, LocalDateTime end);
    List<CitaDTO> findByTipoCita(String tipoCita);
    List<CitaDTO> findByEstadoCita(String estadoCita);
}
