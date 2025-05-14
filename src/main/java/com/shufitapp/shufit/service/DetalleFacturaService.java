package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.DetalleFacturaDTO;

public interface DetalleFacturaService {
    List<DetalleFacturaDTO> findAll();

    DetalleFacturaDTO findById(Integer id);

    DetalleFacturaDTO save(DetalleFacturaDTO dto);

    DetalleFacturaDTO update(Integer id, DetalleFacturaDTO dto);

    void deleteById(Integer id);

    List<DetalleFacturaDTO> findByFacturaId(Integer facturaId);
}
