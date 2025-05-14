package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.HorarioClaseGrupalDTO;

public interface HorarioClaseGrupalService {

    List<HorarioClaseGrupalDTO> findAll();
    HorarioClaseGrupalDTO findById(Integer id);
    HorarioClaseGrupalDTO save(HorarioClaseGrupalDTO dto);
    HorarioClaseGrupalDTO update(Integer id, HorarioClaseGrupalDTO dto);
    void deleteById(Integer id);
    List<HorarioClaseGrupalDTO> findByClaseId(Integer claseId);

}
