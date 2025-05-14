package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.EvaluacionInicialDTO;

public interface EvaluacionInicialService {

    List<EvaluacionInicialDTO> findAll();

    EvaluacionInicialDTO findById(Integer id);

    EvaluacionInicialDTO save(EvaluacionInicialDTO dto);

    EvaluacionInicialDTO update(Integer id, EvaluacionInicialDTO dto);

    void deleteById(Integer id);

    EvaluacionInicialDTO findByClienteId(Integer clienteId);
}
