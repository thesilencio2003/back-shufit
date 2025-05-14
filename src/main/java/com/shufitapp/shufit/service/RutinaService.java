package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.RutinaDTO;

public interface RutinaService {

    List<RutinaDTO> findAll();

    RutinaDTO findById(Integer id);

    RutinaDTO save(RutinaDTO dto);

    RutinaDTO update(Integer id, RutinaDTO dto);

    void deleteById(Integer id);

}
