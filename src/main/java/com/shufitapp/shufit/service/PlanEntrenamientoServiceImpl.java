package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.PlanEntrenamiento;
import com.shufitapp.shufit.dto.PlanEntrenamientoDTO;
import com.shufitapp.shufit.repository.PlanEntrenamientoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanEntrenamientoServiceImpl implements PlanEntrenamientoService {

    private final PlanEntrenamientoRepository planEntrenamientoRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<PlanEntrenamientoDTO> findAll() {
        return planEntrenamientoRepo.findAll()
                .stream()
                .map(plan -> modelMapper.map(plan, PlanEntrenamientoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlanEntrenamientoDTO findById(Integer id) {
        PlanEntrenamiento plan = planEntrenamientoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan de entrenamiento no encontrado"));
        return modelMapper.map(plan, PlanEntrenamientoDTO.class);
    }

    @Override
    public PlanEntrenamientoDTO save(PlanEntrenamientoDTO dto) {
        PlanEntrenamiento plan = modelMapper.map(dto, PlanEntrenamiento.class);
        PlanEntrenamiento savedPlan = planEntrenamientoRepo.save(plan);
        return modelMapper.map(savedPlan, PlanEntrenamientoDTO.class);
    }

    @Override
    public PlanEntrenamientoDTO update(Integer id, PlanEntrenamientoDTO dto) {
        PlanEntrenamiento existingPlan = planEntrenamientoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan de entrenamiento no encontrado"));
        modelMapper.map(dto, existingPlan);
        PlanEntrenamiento updatedPlan = planEntrenamientoRepo.save(existingPlan);
        return modelMapper.map(updatedPlan, PlanEntrenamientoDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        planEntrenamientoRepo.deleteById(id);
    }

}
