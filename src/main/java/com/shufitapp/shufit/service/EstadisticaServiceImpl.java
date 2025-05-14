package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Estadistica;
import com.shufitapp.shufit.dto.EstadisticaDTO;
import com.shufitapp.shufit.repository.EstadisticaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstadisticaServiceImpl implements EstadisticaService {

      private final EstadisticaRepository estadisticaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<EstadisticaDTO> findAll() {
        return estadisticaRepo.findAll().stream()
                .map(estadistica -> modelMapper.map(estadistica, EstadisticaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EstadisticaDTO findById(Integer id) {
        Estadistica estadistica = estadisticaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Estadística no encontrada"));
        return modelMapper.map(estadistica, EstadisticaDTO.class);
    }

    @Override
    public List<EstadisticaDTO> findByFechaCalculoRange(LocalDateTime start, LocalDateTime end) {
        return estadisticaRepo.findByFechaCalculoBetween(start, end).stream()
                .map(estadistica -> modelMapper.map(estadistica, EstadisticaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EstadisticaDTO getLatestStatistics() {
        Estadistica estadistica = estadisticaRepo.findTopByOrderByFechaCalculoDesc();
        return estadistica != null ? modelMapper.map(estadistica, EstadisticaDTO.class) : null;
    }
}
