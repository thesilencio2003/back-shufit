package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Rutina;
import com.shufitapp.shufit.dto.RutinaDTO;
import com.shufitapp.shufit.repository.RutinaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RutinaServiceImpl implements RutinaService {

    private final RutinaRepository rutinaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<RutinaDTO> findAll() {
        return rutinaRepo.findAll()
                .stream()
                .map(rutina -> modelMapper.map(rutina, RutinaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RutinaDTO findById(Integer id) {
        Rutina rutina = rutinaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));
        return modelMapper.map(rutina, RutinaDTO.class);
    }

    @Override
    public RutinaDTO save(RutinaDTO dto) {
        Rutina rutina = modelMapper.map(dto, Rutina.class);
        Rutina savedRutina = rutinaRepo.save(rutina);
        return modelMapper.map(savedRutina, RutinaDTO.class);
    }

    @Override
    public RutinaDTO update(Integer id, RutinaDTO dto) {
        Rutina existingRutina = rutinaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));
        modelMapper.map(dto, existingRutina);
        Rutina updatedRutina = rutinaRepo.save(existingRutina);
        return modelMapper.map(updatedRutina, RutinaDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        rutinaRepo.deleteById(id);
    }    

}
