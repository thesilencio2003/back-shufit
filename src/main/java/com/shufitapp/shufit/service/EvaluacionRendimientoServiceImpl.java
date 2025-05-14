package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Cliente;
import com.shufitapp.shufit.controller.EvaluacionRendimiento;
import com.shufitapp.shufit.dto.EvaluacionRendimientoDTO;
import com.shufitapp.shufit.repository.ClienteRepository;
import com.shufitapp.shufit.repository.EvaluacionRendimientoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EvaluacionRendimientoServiceImpl implements EvaluacionRendimientoService {

    private final EvaluacionRendimientoRepository evaluacionRendimientoRepo;
    private final ClienteRepository clienteRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<EvaluacionRendimientoDTO> findAll() {
        return evaluacionRendimientoRepo.findAll().stream()
                .map(evaluacionRendimiento -> modelMapper.map(evaluacionRendimiento, EvaluacionRendimientoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EvaluacionRendimientoDTO findById(Integer id) {
        EvaluacionRendimiento evaluacionRendimiento = evaluacionRendimientoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluación de rendimiento no encontrada"));
        return modelMapper.map(evaluacionRendimiento, EvaluacionRendimientoDTO.class);
    }

    @Override
    public EvaluacionRendimientoDTO save(EvaluacionRendimientoDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        EvaluacionRendimiento evaluacionRendimiento = modelMapper.map(dto, EvaluacionRendimiento.class);
        evaluacionRendimiento.setCliente(cliente);
        EvaluacionRendimiento savedEvaluacionRendimiento = evaluacionRendimientoRepo.save(evaluacionRendimiento);
        return modelMapper.map(savedEvaluacionRendimiento, EvaluacionRendimientoDTO.class);
    }

    @Override
    public EvaluacionRendimientoDTO update(Integer id, EvaluacionRendimientoDTO dto) {
        EvaluacionRendimiento existingEvaluacionRendimiento = evaluacionRendimientoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluación de rendimiento no encontrada"));
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        modelMapper.map(dto, existingEvaluacionRendimiento);
        existingEvaluacionRendimiento.setCliente(cliente);
        EvaluacionRendimiento updatedEvaluacionRendimiento = evaluacionRendimientoRepo.save(existingEvaluacionRendimiento);
        return modelMapper.map(updatedEvaluacionRendimiento, EvaluacionRendimientoDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        evaluacionRendimientoRepo.deleteById(id);
    }

    @Override
    public List<EvaluacionRendimientoDTO> findByClienteId(Integer clienteId) {
        return evaluacionRendimientoRepo.findByCliente_IdClienteOrderByFechaEvaluacionDesc(clienteId).stream()
                .map(evaluacionRendimiento -> modelMapper.map(evaluacionRendimiento, EvaluacionRendimientoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EvaluacionRendimientoDTO> findByDateRange(LocalDateTime start, LocalDateTime end) {
        return evaluacionRendimientoRepo.findByFechaEvaluacionBetween(start, end).stream()
                .map(evaluacionRendimiento -> modelMapper.map(evaluacionRendimiento, EvaluacionRendimientoDTO.class))
                .collect(Collectors.toList());
    }

}
