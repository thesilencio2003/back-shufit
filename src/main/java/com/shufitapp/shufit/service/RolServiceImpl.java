package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Rol;
import com.shufitapp.shufit.dto.RolDTO;
import com.shufitapp.shufit.repository.RolRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<RolDTO> findAll() {
        return rolRepo.findAll()
                .stream()
                .map(rol -> modelMapper.map(rol, RolDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public RolDTO findById(Integer id) {
        Rol rol = rolRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        return modelMapper.map(rol, RolDTO.class);
    }

    @Override
    public RolDTO save(RolDTO dto) {
        if (rolRepo.existsByNombreRol(dto.getNombreRol())) {
            throw new RuntimeException("El nombre del rol ya existe");
        }
        Rol rol = modelMapper.map(dto, Rol.class);
        Rol savedRol = rolRepo.save(rol);
        return modelMapper.map(savedRol, RolDTO.class);
    }

    @Override
    public RolDTO update(Integer id, RolDTO dto) {
        Rol existingRol = rolRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        modelMapper.map(dto, existingRol);
        Rol updatedRol = rolRepo.save(existingRol);
        return modelMapper.map(updatedRol, RolDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        rolRepo.deleteById(id);
    }

}
