package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;

import com.shufitapp.shufit.dto.AuditoriaDTO;

public interface AuditoriaService {

    List<AuditoriaDTO> findAll();

    AuditoriaDTO findById(Integer id);

    List<AuditoriaDTO> findByUsuario(String usuario);

    List<AuditoriaDTO> findByTipoEvento(String tipoEvento);

    List<AuditoriaDTO> findByEntidadAfectada(String entidadAfectada);

    List<AuditoriaDTO> findByFechaHoraEventoBetween(LocalDateTime start, LocalDateTime end);

    List<AuditoriaDTO> findByEntidadAfectadaAndIdEntidadAfectada(String entidadAfectada, Integer idEntidadAfectada);

}
