package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.FacturaDTO;

public interface FacturaService {

    List<FacturaDTO> findAll();

    FacturaDTO findById(Integer id);

    FacturaDTO save(FacturaDTO dto);

    FacturaDTO update(Integer id, FacturaDTO dto);

    void deleteById(Integer id);

    List<FacturaDTO> findByClienteId(Integer clienteId);

    FacturaDTO findByCabeceraFacturaId(Integer idCabeceraFactura);

}
