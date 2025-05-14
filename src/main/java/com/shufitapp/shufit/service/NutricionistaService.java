package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.NutricionistaDTO;

public interface NutricionistaService {
    List<NutricionistaDTO> findAll();
    NutricionistaDTO findById(Integer id);
    NutricionistaDTO save(NutricionistaDTO dto);
    NutricionistaDTO update(Integer id, NutricionistaDTO dto);
    void deleteById(Integer id);
    NutricionistaDTO findByPersonaId(Integer personaId);
}
