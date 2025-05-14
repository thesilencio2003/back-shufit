package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.BodegaDTO;

public interface BodegaService {
    List<BodegaDTO> findAll();
    BodegaDTO findById(Integer id);
    BodegaDTO save(BodegaDTO dto);
    BodegaDTO update(Integer id, BodegaDTO dto);
    void deleteById(Integer id);
    List<BodegaDTO> findByNombre(String nombre);
}
