package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.RecepcionistaDTO;

public interface RecepcionistaService {

    List<RecepcionistaDTO> findAll();

    RecepcionistaDTO findById(Integer id);

    RecepcionistaDTO save(RecepcionistaDTO dto);

    RecepcionistaDTO update(Integer id, RecepcionistaDTO dto);

    void deleteById(Integer id);

    RecepcionistaDTO findByPersonaId(Integer personaId);
}
