package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Cita;
import com.shufitapp.shufit.Models.Cliente;
import com.shufitapp.shufit.Models.Entrenador;
import com.shufitapp.shufit.Models.Nutricionista;
import com.shufitapp.shufit.dto.CitaDTO;
import com.shufitapp.shufit.repository.CitaRepository;
import com.shufitapp.shufit.repository.ClienteRepository;
import com.shufitapp.shufit.repository.EntrenadorRepository;
import com.shufitapp.shufit.repository.NutricionistaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepo;
    private final ClienteRepository clienteRepo;
    private final EntrenadorRepository entrenadorRepo;
    private final NutricionistaRepository nutricionistaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<CitaDTO> findAll() {
        return citaRepo.findAll().stream().map(cita -> modelMapper.map(cita, CitaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CitaDTO findById(Integer id) {
        Cita cita = citaRepo.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        return modelMapper.map(cita, CitaDTO.class);
    }

    @Override
    public CitaDTO save(CitaDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getClienteId()).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Entrenador entrenador = null;
        if (dto.getEntrenadorId() != null) {
            entrenador = entrenadorRepo.findById(dto.getEntrenadorId()).orElse(null);
        }
        Nutricionista nutricionista = null;
        if (dto.getNutricionistaId() != null) {
            nutricionista = nutricionistaRepo.findById(dto.getNutricionistaId()).orElse(null);
        }
        Cita cita = modelMapper.map(dto, Cita.class);
        cita.setCliente(cliente);
        cita.setEntrenador(entrenador);
        cita.setNutricionista(nutricionista);
        Cita savedCita = citaRepo.save(cita);
        return modelMapper.map(savedCita, CitaDTO.class);
    }

    @Override
    public CitaDTO update(Integer id, CitaDTO dto) {
        Cita existingCita = citaRepo.findById(id).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        Cliente cliente = clienteRepo.findById(dto.getClienteId()).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Entrenador entrenador = null;
        if (dto.getEntrenadorId() != null) {
            entrenador = entrenadorRepo.findById(dto.getEntrenadorId()).orElse(null);
        } else {
            existingCita.setEntrenador(null);
        }
        Nutricionista nutricionista = null;
        if (dto.getNutricionistaId() != null) {
            nutricionista = nutricionistaRepo.findById(dto.getNutricionistaId()).orElse(null);
        } else {
            existingCita.setNutricionista(null);
        }
        modelMapper.map(dto, existingCita);
        existingCita.setCliente(cliente);
        existingCita.setEntrenador(entrenador);
        existingCita.setNutricionista(nutricionista);
        Cita updatedCita = citaRepo.save(existingCita);
        return modelMapper.map(updatedCita, CitaDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        citaRepo.deleteById(id);
    }

    @Override
    public List<CitaDTO> findByClienteId(Integer clienteId) {
        return citaRepo.findByCliente_IdCliente(clienteId).stream().map(cita -> modelMapper.map(cita, CitaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<CitaDTO> findByEntrenadorId(Integer entrenadorId) {
        return citaRepo.findByEntrenador_IdEntrenador(entrenadorId).stream().map(cita -> modelMapper.map(cita, CitaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<CitaDTO> findByNutricionistaId(Integer nutricionistaId) {
        return citaRepo.findByNutricionista_IdNutricionista(nutricionistaId).stream().map(cita -> modelMapper.map(cita, CitaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<CitaDTO> findByFechaHoraBetween(LocalDateTime start, LocalDateTime end) {
        return citaRepo.findByFechaHoraBetween(start, end).stream().map(cita -> modelMapper.map(cita, CitaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<CitaDTO> findByTipoCita(String tipoCita) {
        return citaRepo.findByTipoCita(tipoCita).stream().map(cita -> modelMapper.map(cita, CitaDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<CitaDTO> findByEstadoCita(String estadoCita) {
        return citaRepo.findByEstadoCita(estadoCita).stream().map(cita -> modelMapper.map(cita, CitaDTO.class)).collect(Collectors.toList());
    }
}
