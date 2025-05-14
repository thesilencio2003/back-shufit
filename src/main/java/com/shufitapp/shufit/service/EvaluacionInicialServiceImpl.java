package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Cliente;
import com.shufitapp.shufit.Models.EvaluacionInicial;
import com.shufitapp.shufit.dto.EvaluacionInicialDTO;
import com.shufitapp.shufit.repository.ClienteRepository;
import com.shufitapp.shufit.repository.EvaluacionInicialRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EvaluacionInicialServiceImpl implements EvaluacionInicialService {
private final EvaluacionInicialRepository evaluacionInicialRepo;
    private final ClienteRepository clienteRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<EvaluacionInicialDTO> findAll() {
        return evaluacionInicialRepo.findAll().stream()
                .map(evaluacionInicial -> modelMapper.map(evaluacionInicial, EvaluacionInicialDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EvaluacionInicialDTO findById(Integer id) {
        EvaluacionInicial evaluacionInicial = evaluacionInicialRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluación inicial no encontrada"));
        return modelMapper.map(evaluacionInicial, EvaluacionInicialDTO.class);
    }

    @Override
    public EvaluacionInicialDTO save(EvaluacionInicialDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        if (evaluacionInicialRepo.existsByCliente_IdCliente(cliente.getIdCliente())) {
            throw new RuntimeException("Ya existe una evaluación inicial para el cliente con ID " + cliente.getIdCliente());
        }

        EvaluacionInicial evaluacionInicial = modelMapper.map(dto, EvaluacionInicial.class);
        evaluacionInicial.setCliente(cliente);
        EvaluacionInicial savedEvaluacionInicial = evaluacionInicialRepo.save(evaluacionInicial);
        return modelMapper.map(savedEvaluacionInicial, EvaluacionInicialDTO.class);
    }

    @Override
    public EvaluacionInicialDTO update(Integer id, EvaluacionInicialDTO dto) {
        EvaluacionInicial existingEvaluacionInicial = evaluacionInicialRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluación inicial no encontrada"));

        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        if (!existingEvaluacionInicial.getCliente().getIdCliente().equals(cliente.getIdCliente()) &&
            evaluacionInicialRepo.existsByCliente_IdCliente(cliente.getIdCliente())) {
            throw new RuntimeException("Ya existe otra evaluación inicial asociada al cliente con ID " + cliente.getIdCliente());
        }

        modelMapper.map(dto, existingEvaluacionInicial);
        existingEvaluacionInicial.setCliente(cliente);
        EvaluacionInicial updatedEvaluacionInicial = evaluacionInicialRepo.save(existingEvaluacionInicial);
        return modelMapper.map(updatedEvaluacionInicial, EvaluacionInicialDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        evaluacionInicialRepo.deleteById(id);
    }

    @Override
    public EvaluacionInicialDTO findByClienteId(Integer clienteId) {
        EvaluacionInicial evaluacionInicial = evaluacionInicialRepo.findByCliente_IdCliente(clienteId)
                .orElseThrow(() -> new RuntimeException("No se encontró evaluación inicial para el cliente con ID " + clienteId));
        return modelMapper.map(evaluacionInicial, EvaluacionInicialDTO.class);
    }
}
