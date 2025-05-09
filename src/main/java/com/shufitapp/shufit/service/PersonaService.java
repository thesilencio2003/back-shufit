package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.PersonaDTO;

public interface PersonaService {
    List<PersonaDTO> findAll();
    PersonaDTO findById(Integer id);
    PersonaDTO save(PersonaDTO personaDTO);
    PersonaDTO update(Integer id, PersonaDTO personaDTO);
    void deleteById(Integer id);
}
