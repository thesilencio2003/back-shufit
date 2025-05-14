package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.PlanAlimentacionDTO;

public interface PlanAlimentacionService {
    List<PlanAlimentacionDTO> findAll();
    PlanAlimentacionDTO findById(Integer id);
    PlanAlimentacionDTO save(PlanAlimentacionDTO dto);
    PlanAlimentacionDTO update(Integer id, PlanAlimentacionDTO dto);
    void deleteById(Integer id);
    List<PlanAlimentacionDTO> findByClienteId(Integer clienteId);
    List<PlanAlimentacionDTO> findActivos();
    List<PlanAlimentacionDTO> findByObjetivo(String objetivo);
}
