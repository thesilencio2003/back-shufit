package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.RolDTO;

public interface RolService {

    List<RolDTO> findAll();

    RolDTO findById(Integer id);

    RolDTO save(RolDTO dto);

    RolDTO update(Integer id, RolDTO dto);

    void deleteById(Integer id);
}
