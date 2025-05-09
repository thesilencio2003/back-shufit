package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.ClienteDTO;

public interface ClienteService {
    
    List<ClienteDTO> findAll();
    ClienteDTO findById(Integer id);
    ClienteDTO save(ClienteDTO dto);
    ClienteDTO update(Integer id, ClienteDTO dto);
    void deleteById(Integer id);
}
