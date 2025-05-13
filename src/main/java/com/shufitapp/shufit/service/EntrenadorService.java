package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.EntrenadorDTO;

public interface EntrenadorService {

    List<EntrenadorDTO> findAll();

    EntrenadorDTO findById(Integer id);

    EntrenadorDTO save(EntrenadorDTO dto);

    EntrenadorDTO update(Integer id, EntrenadorDTO dto);

    void deleteById(Integer id);

    EntrenadorDTO findByPersonaId(Integer personaId);

}
