package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;

import com.shufitapp.shufit.dto.EstadisticaDTO;

public interface EstadisticaService {

    List<EstadisticaDTO> findAll();

    EstadisticaDTO findById(Integer id);

    List<EstadisticaDTO> findByFechaCalculoRange(LocalDateTime start, LocalDateTime end);

    EstadisticaDTO getLatestStatistics();

}
