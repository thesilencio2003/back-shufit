package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Auditoria;
import com.shufitapp.shufit.dto.AuditoriaDTO;
import com.shufitapp.shufit.repository.AuditoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditoriaServiceImpl implements AuditoriaService  {
    private final AuditoriaRepository auditoriaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<AuditoriaDTO> findAll() {
        return auditoriaRepo.findAll().stream()
                .map(auditoria -> modelMapper.map(auditoria, AuditoriaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AuditoriaDTO findById(Integer id) {
        Auditoria auditoria = auditoriaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de auditoría no encontrado"));
        return modelMapper.map(auditoria, AuditoriaDTO.class);
    }

    @Override
    public List<AuditoriaDTO> findByUsuario(String usuario) {
        return auditoriaRepo.findByUsuarioContainingIgnoreCase(usuario).stream()
                .map(auditoria -> modelMapper.map(auditoria, AuditoriaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuditoriaDTO> findByTipoEvento(String tipoEvento) {
        return auditoriaRepo.findByTipoEvento(tipoEvento).stream()
                .map(auditoria -> modelMapper.map(auditoria, AuditoriaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuditoriaDTO> findByEntidadAfectada(String entidadAfectada) {
        return auditoriaRepo.findByEntidadAfectadaIgnoreCase(entidadAfectada).stream()
                .map(auditoria -> modelMapper.map(auditoria, AuditoriaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuditoriaDTO> findByFechaHoraEventoBetween(LocalDateTime start, LocalDateTime end) {
        return auditoriaRepo.findByFechaHoraEventoBetween(start, end).stream()
                .map(auditoria -> modelMapper.map(auditoria, AuditoriaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuditoriaDTO> findByEntidadAfectadaAndIdEntidadAfectada(String entidadAfectada, Integer idEntidadAfectada) {
        return auditoriaRepo.findByEntidadAfectadaIgnoreCaseAndIdEntidadAfectada(entidadAfectada, idEntidadAfectada).stream()
                .map(auditoria -> modelMapper.map(auditoria, AuditoriaDTO.class))
                .collect(Collectors.toList());
    }
}
