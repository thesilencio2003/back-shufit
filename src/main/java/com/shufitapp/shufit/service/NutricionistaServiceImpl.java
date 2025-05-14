package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Nutricionista;
import com.shufitapp.shufit.Models.Persona;
import com.shufitapp.shufit.dto.NutricionistaDTO;
import com.shufitapp.shufit.repository.NutricionistaRepository;
import com.shufitapp.shufit.repository.PersonaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NutricionistaServiceImpl implements NutricionistaService {

      private final NutricionistaRepository nutricionistaRepo;
    private final PersonaRepository personaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<NutricionistaDTO> findAll() {
        return nutricionistaRepo.findAll()
                .stream()
                .map(nutricionista -> modelMapper.map(nutricionista, NutricionistaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public NutricionistaDTO findById(Integer id) {
        Nutricionista nutricionista = nutricionistaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Nutricionista no encontrado"));
        return modelMapper.map(nutricionista, NutricionistaDTO.class);
    }

    @Override
    public NutricionistaDTO save(NutricionistaDTO dto) {
        Persona persona = personaRepo.findById(dto.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        if (nutricionistaRepo.existsByPersona_IdPersona(persona.getIdPersona())) {
            throw new RuntimeException("Ya existe un nutricionista asociado a la persona con ID " + persona.getIdPersona());
        }

        if (nutricionistaRepo.existsByCedulaProfesional(dto.getCedulaProfesional())) {
            throw new RuntimeException("Ya existe un nutricionista con la cédula profesional " + dto.getCedulaProfesional());
        }

        Nutricionista nutricionista = modelMapper.map(dto, Nutricionista.class);
        nutricionista.setPersona(persona);
        Nutricionista savedNutricionista = nutricionistaRepo.save(nutricionista);
        return modelMapper.map(savedNutricionista, NutricionistaDTO.class);
    }

    @Override
    public NutricionistaDTO update(Integer id, NutricionistaDTO dto) {
        Nutricionista existingNutricionista = nutricionistaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Nutricionista no encontrado"));

        Persona persona = personaRepo.findById(dto.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        if (!existingNutricionista.getPersona().getIdPersona().equals(persona.getIdPersona()) &&
            nutricionistaRepo.existsByPersona_IdPersona(persona.getIdPersona())) {
            throw new RuntimeException("Ya existe otro nutricionista asociado a la persona con ID " + persona.getIdPersona());
        }

        if (!existingNutricionista.getCedulaProfesional().equals(dto.getCedulaProfesional()) &&
            nutricionistaRepo.existsByCedulaProfesional(dto.getCedulaProfesional())) {
            throw new RuntimeException("Ya existe otro nutricionista con la cédula profesional " + dto.getCedulaProfesional());
        }

        modelMapper.map(dto, existingNutricionista);
        existingNutricionista.setPersona(persona);
        Nutricionista updatedNutricionista = nutricionistaRepo.save(existingNutricionista);
        return modelMapper.map(updatedNutricionista, NutricionistaDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        nutricionistaRepo.deleteById(id);
    }

    @Override
    public NutricionistaDTO findByPersonaId(Integer personaId) {
        Nutricionista nutricionista = nutricionistaRepo.findByPersona_IdPersona(personaId)
                .orElseThrow(() -> new RuntimeException("No se encontró nutricionista asociado a la persona con ID " + personaId));
        return modelMapper.map(nutricionista, NutricionistaDTO.class);
    }

}
