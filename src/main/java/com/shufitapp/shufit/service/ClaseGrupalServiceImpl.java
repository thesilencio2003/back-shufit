package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.ClaseGrupal;
import com.shufitapp.shufit.dto.ClaseGrupalDTO;
import com.shufitapp.shufit.repository.ClaseGrupalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClaseGrupalServiceImpl implements ClaseGrupalService {

    private final ClaseGrupalRepository claseGrupalRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ClaseGrupalDTO> findAll() {
        return claseGrupalRepo.findAll()
                .stream()
                .map(clase -> modelMapper.map(clase, ClaseGrupalDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClaseGrupalDTO findById(Integer id) {
        ClaseGrupal clase = claseGrupalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase grupal no encontrada"));
        return modelMapper.map(clase, ClaseGrupalDTO.class);
    }

    @Override
    public ClaseGrupalDTO save(ClaseGrupalDTO dto) {
        ClaseGrupal clase = modelMapper.map(dto, ClaseGrupal.class);
        ClaseGrupal savedClase = claseGrupalRepo.save(clase);
        return modelMapper.map(savedClase, ClaseGrupalDTO.class);
    }

    @Override
    public ClaseGrupalDTO update(Integer id, ClaseGrupalDTO dto) {
        ClaseGrupal existingClase = claseGrupalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Clase grupal no encontrada"));
        modelMapper.map(dto, existingClase);
        ClaseGrupal updatedClase = claseGrupalRepo.save(existingClase);
        return modelMapper.map(updatedClase, ClaseGrupalDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        claseGrupalRepo.deleteById(id);
    }

}
