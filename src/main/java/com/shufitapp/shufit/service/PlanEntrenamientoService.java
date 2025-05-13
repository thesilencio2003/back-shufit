package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.PlanEntrenamientoDTO;

public interface PlanEntrenamientoService {

    List<PlanEntrenamientoDTO> findAll();

    PlanEntrenamientoDTO findById(Integer id);

    PlanEntrenamientoDTO save(PlanEntrenamientoDTO dto);

    PlanEntrenamientoDTO update(Integer id, PlanEntrenamientoDTO dto);

    void deleteById(Integer id);
}
