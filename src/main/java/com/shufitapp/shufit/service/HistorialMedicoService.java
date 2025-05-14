package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.HistorialMedicoDTO;

public interface HistorialMedicoService {
    List<HistorialMedicoDTO> findAll();

    HistorialMedicoDTO findById(Integer id);

    HistorialMedicoDTO save(HistorialMedicoDTO dto);

    HistorialMedicoDTO update(Integer id, HistorialMedicoDTO dto);

    void deleteById(Integer id);

    HistorialMedicoDTO findByClienteId(Integer clienteId);
}
