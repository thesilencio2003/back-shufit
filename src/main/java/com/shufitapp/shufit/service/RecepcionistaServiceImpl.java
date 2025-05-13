package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Persona;
import com.shufitapp.shufit.Models.Recepcionista;
import com.shufitapp.shufit.dto.RecepcionistaDTO;
import com.shufitapp.shufit.repository.PersonaRepository;
import com.shufitapp.shufit.repository.RecepcionistaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecepcionistaServiceImpl implements RecepcionistaService {

        private final RecepcionistaRepository recepcionistaRepo;
    private final PersonaRepository personaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<RecepcionistaDTO> findAll() {
        return recepcionistaRepo.findAll()
                .stream()
                .map(recepcionista -> modelMapper.map(recepcionista, RecepcionistaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RecepcionistaDTO findById(Integer id) {
        Recepcionista recepcionista = recepcionistaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Recepcionista no encontrado"));
        return modelMapper.map(recepcionista, RecepcionistaDTO.class);
    }

    @Override
    public RecepcionistaDTO save(RecepcionistaDTO dto) {
        Persona persona = personaRepo.findById(dto.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        if (recepcionistaRepo.existsByPersona_IdPersona(persona.getIdPersona())) {
            throw new RuntimeException("Ya existe un recepcionista asociado a la persona con ID " + persona.getIdPersona());
        }

        Recepcionista recepcionista = modelMapper.map(dto, Recepcionista.class);
        recepcionista.setPersona(persona);
        Recepcionista savedRecepcionista = recepcionistaRepo.save(recepcionista);
        return modelMapper.map(savedRecepcionista, RecepcionistaDTO.class);
    }

    @Override
    public RecepcionistaDTO update(Integer id, RecepcionistaDTO dto) {
        Recepcionista existingRecepcionista = recepcionistaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Recepcionista no encontrado"));

        Persona persona = personaRepo.findById(dto.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        if (!existingRecepcionista.getPersona().getIdPersona().equals(persona.getIdPersona()) &&
            recepcionistaRepo.existsByPersona_IdPersona(persona.getIdPersona())) {
            throw new RuntimeException("Ya existe otro recepcionista asociado a la persona con ID " + persona.getIdPersona());
        }

        modelMapper.map(dto, existingRecepcionista);
        existingRecepcionista.setPersona(persona);
        Recepcionista updatedRecepcionista = recepcionistaRepo.save(existingRecepcionista);
        return modelMapper.map(updatedRecepcionista, RecepcionistaDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        recepcionistaRepo.deleteById(id);
    }

    @Override
    public RecepcionistaDTO findByPersonaId(Integer personaId) {
        Recepcionista recepcionista = recepcionistaRepo.findByPersona_IdPersona(personaId)
                .orElseThrow(() -> new RuntimeException("No se encontró recepcionista asociado a la persona con ID " + personaId));
        return modelMapper.map(recepcionista, RecepcionistaDTO.class);
    }

}
