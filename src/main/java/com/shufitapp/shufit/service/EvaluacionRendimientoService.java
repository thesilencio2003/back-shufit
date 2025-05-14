package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;

import com.shufitapp.shufit.dto.EvaluacionRendimientoDTO;

public interface EvaluacionRendimientoService {

    List<EvaluacionRendimientoDTO> findAll();

    EvaluacionRendimientoDTO findById(Integer id);

    EvaluacionRendimientoDTO save(EvaluacionRendimientoDTO dto);

    EvaluacionRendimientoDTO update(Integer id, EvaluacionRendimientoDTO dto);

    void deleteById(Integer id);

    List<EvaluacionRendimientoDTO> findByClienteId(Integer clienteId);

    List<EvaluacionRendimientoDTO> findByDateRange(LocalDateTime start, LocalDateTime end);

}
