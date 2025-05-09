package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Persona;
import com.shufitapp.shufit.dto.PersonaDTO;
import com.shufitapp.shufit.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

     private final PersonaRepository personaRepo;
    private final ModelMapper modelMapper;

    public PersonaServiceImpl(PersonaRepository personaRepo, ModelMapper modelMapper) {
        this.personaRepo = personaRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PersonaDTO> findAll() {
        return personaRepo.findAll()
                .stream()
                .map(p -> modelMapper.map(p, PersonaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PersonaDTO findById(Integer id) {
        return personaRepo.findById(id)
                .map(p -> modelMapper.map(p, PersonaDTO.class))
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Override
    public PersonaDTO save(PersonaDTO dto) {
        Persona persona = modelMapper.map(dto, Persona.class);
        persona.setFechaRegistro(LocalDateTime.now());
        persona.setFechaActualizacion(LocalDateTime.now());
        return modelMapper.map(personaRepo.save(persona), PersonaDTO.class);
    }

    @Override
    public PersonaDTO update(Integer id, PersonaDTO dto) {
        Persona existing = personaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(dto, existing);

        existing.setFechaActualizacion(LocalDateTime.now());

        return modelMapper.map(personaRepo.save(existing), PersonaDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        personaRepo.deleteById(id);
    }

}
