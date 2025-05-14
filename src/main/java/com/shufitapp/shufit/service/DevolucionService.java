package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;

import com.shufitapp.shufit.dto.DevolucionDTO;

public interface DevolucionService {

    List<DevolucionDTO> findAll();

    DevolucionDTO findById(Integer id);

    DevolucionDTO save(DevolucionDTO dto);

    DevolucionDTO update(Integer id, DevolucionDTO dto);

    void deleteById(Integer id);

    List<DevolucionDTO> findByFacturaId(Integer facturaId);

    List<DevolucionDTO> findByEstado(String estadoDevolucion);

    List<DevolucionDTO> findByFechaSolicitudRange(LocalDateTime start, LocalDateTime end);

}
