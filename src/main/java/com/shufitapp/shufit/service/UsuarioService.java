package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.UsuarioDTO;

public interface UsuarioService {

    List<UsuarioDTO> findAll();
    UsuarioDTO findById(Integer id);
    UsuarioDTO save(UsuarioDTO dto);
    UsuarioDTO update(Integer id, UsuarioDTO dto);
    void deleteById(Integer id);

}
