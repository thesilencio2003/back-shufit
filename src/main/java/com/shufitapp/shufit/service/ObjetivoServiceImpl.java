package com.shufitapp.shufit.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Cliente;
import com.shufitapp.shufit.Models.Objetivo;
import com.shufitapp.shufit.dto.ObjetivoDTO;
import com.shufitapp.shufit.repository.ClienteRepository;
import com.shufitapp.shufit.repository.ObjetivoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObjetivoServiceImpl implements ObjetivoService {

     private final ObjetivoRepository objetivoRepo;
    private final ClienteRepository clienteRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ObjetivoDTO> findAll() {
        return objetivoRepo.findAll().stream().map(objetivo -> modelMapper.map(objetivo, ObjetivoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ObjetivoDTO findById(Integer id) {
        Objetivo objetivo = objetivoRepo.findById(id).orElseThrow(() -> new RuntimeException("Objetivo no encontrado"));
        return modelMapper.map(objetivo, ObjetivoDTO.class);
    }

    @Override
    public ObjetivoDTO save(ObjetivoDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getClienteId()).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Objetivo objetivo = modelMapper.map(dto, Objetivo.class);
        objetivo.setCliente(cliente);
        Objetivo savedObjetivo = objetivoRepo.save(objetivo);
        return modelMapper.map(savedObjetivo, ObjetivoDTO.class);
    }

    @Override
    public ObjetivoDTO update(Integer id, ObjetivoDTO dto) {
        Objetivo existingObjetivo = objetivoRepo.findById(id).orElseThrow(() -> new RuntimeException("Objetivo no encontrado"));
        Cliente cliente = clienteRepo.findById(dto.getClienteId()).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        modelMapper.map(dto, existingObjetivo);
        existingObjetivo.setCliente(cliente);
        Objetivo updatedObjetivo = objetivoRepo.save(existingObjetivo);
        return modelMapper.map(updatedObjetivo, ObjetivoDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        objetivoRepo.deleteById(id);
    }

    @Override
    public List<ObjetivoDTO> findByClientId(Integer clienteId) {
        return objetivoRepo.findByCliente_IdCliente(clienteId).stream().map(objetivo -> modelMapper.map(objetivo, ObjetivoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObjetivoDTO> findByType(String tipoObjetivo) {
        return objetivoRepo.findByTipoObjetivoIgnoreCase(tipoObjetivo).stream().map(objetivo -> modelMapper.map(objetivo, ObjetivoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObjetivoDTO> findByStatus(String estadoObjetivo) {
        return objetivoRepo.findByEstadoObjetivoIgnoreCase(estadoObjetivo).stream().map(objetivo -> modelMapper.map(objetivo, ObjetivoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObjetivoDTO> findByStartDateBetween(LocalDate start, LocalDate end) {
        return objetivoRepo.findByFechaInicioBetween(start, end).stream().map(objetivo -> modelMapper.map(objetivo, ObjetivoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObjetivoDTO> findByEndDateBetween(LocalDate start, LocalDate end) {
        return objetivoRepo.findByFechaFinBetween(start, end).stream().map(objetivo -> modelMapper.map(objetivo, ObjetivoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObjetivoDTO> findActiveByClientId(Integer clienteId) {
        return objetivoRepo.findByCliente_IdClienteAndEstadoObjetivoIgnoreCase(clienteId, "En progreso").stream()
                .map(objetivo -> modelMapper.map(objetivo, ObjetivoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ObjetivoDTO updateProgress(Integer id, Double progreso) {
        Objetivo objetivo = objetivoRepo.findById(id).orElseThrow(() -> new RuntimeException("Objetivo no encontrado"));
        objetivo.setProgreso(progreso);
        objetivo.setFechaProgresoActualizacion(LocalDateTime.now());
        Objetivo updatedObjetivo = objetivoRepo.save(objetivo);
        return modelMapper.map(updatedObjetivo, ObjetivoDTO.class);
    }

    @Override
    public ObjetivoDTO updateStatus(Integer id, String estadoObjetivo) {
        Objetivo objetivo = objetivoRepo.findById(id).orElseThrow(() -> new RuntimeException("Objetivo no encontrado"));
        objetivo.setEstadoObjetivo(estadoObjetivo);
        Objetivo updatedObjetivo = objetivoRepo.save(objetivo);
        return modelMapper.map(updatedObjetivo, ObjetivoDTO.class);
    }

}
