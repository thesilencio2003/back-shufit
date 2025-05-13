package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Entrenador;
import com.shufitapp.shufit.Models.Persona;
import com.shufitapp.shufit.dto.EntrenadorDTO;
import com.shufitapp.shufit.repository.EntrenadorRepository;
import com.shufitapp.shufit.repository.PersonaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntrenadorServiceImpl implements EntrenadorService {

     private final EntrenadorRepository entrenadorRepo;
    private final PersonaRepository personaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<EntrenadorDTO> findAll() {
        return entrenadorRepo.findAll()
                .stream()
                .map(entrenador -> modelMapper.map(entrenador, EntrenadorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EntrenadorDTO findById(Integer id) {
        Entrenador entrenador = entrenadorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));
        return modelMapper.map(entrenador, EntrenadorDTO.class);
    }

    @Override
    public EntrenadorDTO save(EntrenadorDTO dto) {
        Persona persona = personaRepo.findById(dto.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        if (entrenadorRepo.existsByPersona_IdPersona(persona.getIdPersona())) {
            throw new RuntimeException("Ya existe un entrenador asociado a la persona con ID " + persona.getIdPersona());
        }

        Entrenador entrenador = modelMapper.map(dto, Entrenador.class);
        entrenador.setPersona(persona);
        Entrenador savedEntrenador = entrenadorRepo.save(entrenador);
        return modelMapper.map(savedEntrenador, EntrenadorDTO.class);
    }

    @Override
    public EntrenadorDTO update(Integer id, EntrenadorDTO dto) {
        Entrenador existingEntrenador = entrenadorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));

        Persona persona = personaRepo.findById(dto.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        if (!existingEntrenador.getPersona().getIdPersona().equals(persona.getIdPersona()) &&
            entrenadorRepo.existsByPersona_IdPersona(persona.getIdPersona())) {
            throw new RuntimeException("Ya existe otro entrenador asociado a la persona con ID " + persona.getIdPersona());
        }

        modelMapper.map(dto, existingEntrenador);
        existingEntrenador.setPersona(persona);
        Entrenador updatedEntrenador = entrenadorRepo.save(existingEntrenador);
        return modelMapper.map(updatedEntrenador, EntrenadorDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        entrenadorRepo.deleteById(id);
    }

    @Override
    public EntrenadorDTO findByPersonaId(Integer personaId) {
        Entrenador entrenador = entrenadorRepo.findByPersona_IdPersona(personaId)
                .orElseThrow(() -> new RuntimeException("No se encontró entrenador asociado a la persona con ID " + personaId));
        return modelMapper.map(entrenador, EntrenadorDTO.class);
    }

}
