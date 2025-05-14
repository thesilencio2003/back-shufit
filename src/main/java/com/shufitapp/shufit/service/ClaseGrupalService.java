package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.ClaseGrupalDTO;

public interface ClaseGrupalService {

    List<ClaseGrupalDTO> findAll();

    ClaseGrupalDTO findById(Integer id);

    ClaseGrupalDTO save(ClaseGrupalDTO dto);

    ClaseGrupalDTO update(Integer id, ClaseGrupalDTO dto);

    void deleteById(Integer id);

}
