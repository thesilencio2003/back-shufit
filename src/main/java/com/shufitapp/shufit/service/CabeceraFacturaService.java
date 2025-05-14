package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.CabeceraFacturaDTO;

public interface CabeceraFacturaService {
    
    List<CabeceraFacturaDTO> findAll();

    CabeceraFacturaDTO findById(Integer id);

    CabeceraFacturaDTO save(CabeceraFacturaDTO dto);

    CabeceraFacturaDTO update(Integer id, CabeceraFacturaDTO dto);

    void deleteById(Integer id);
}
