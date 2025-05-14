package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.SeguimientoEnvioDTO;

public interface SeguimientoEnvioService {

    List<SeguimientoEnvioDTO> findAll();

    SeguimientoEnvioDTO findById(Integer id);

    SeguimientoEnvioDTO save(SeguimientoEnvioDTO dto);

    SeguimientoEnvioDTO update(Integer id, SeguimientoEnvioDTO dto);

    void deleteById(Integer id);

    SeguimientoEnvioDTO findByFacturaId(Integer facturaId);

    SeguimientoEnvioDTO findByNumeroGuia(String numeroGuia);

    List<SeguimientoEnvioDTO> findByEstadoEnvio(String estadoEnvio);

}
