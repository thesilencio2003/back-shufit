package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.PermisoRol;
import com.shufitapp.shufit.Models.Rol;
import com.shufitapp.shufit.dto.PermisoRolDTO;
import com.shufitapp.shufit.repository.PermisoRolRepository;
import com.shufitapp.shufit.repository.RolRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermisoRolServiceImpl implements PermisoRolService {

        private final PermisoRolRepository permisoRolRepo;
    private final RolRepository rolRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<PermisoRolDTO> findAll() {
        return permisoRolRepo.findAll()
                .stream()
                .map(permisoRol -> modelMapper.map(permisoRol, PermisoRolDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PermisoRolDTO findById(Integer id) {
        PermisoRol permisoRol = permisoRolRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("PermisoRol no encontrado"));
        return modelMapper.map(permisoRol, PermisoRolDTO.class);
    }

    @Override
    public PermisoRolDTO save(PermisoRolDTO dto) {
        Rol rol = rolRepo.findById(dto.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        if (permisoRolRepo.existsByRol_IdRolAndNombrePermiso(rol.getIdRol(), dto.getNombrePermiso())) {
            throw new RuntimeException("El permiso '" + dto.getNombrePermiso() + "' ya existe para el rol '" + rol.getNombreRol() + "'");
        }

        PermisoRol permisoRol = modelMapper.map(dto, PermisoRol.class);
        permisoRol.setRol(rol);
        PermisoRol savedPermisoRol = permisoRolRepo.save(permisoRol);
        return modelMapper.map(savedPermisoRol, PermisoRolDTO.class);
    }

    @Override
    public PermisoRolDTO update(Integer id, PermisoRolDTO dto) {
        PermisoRol existingPermisoRol = permisoRolRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("PermisoRol no encontrado"));

        Rol rol = rolRepo.findById(dto.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        if (!existingPermisoRol.getRol().equals(rol) || !existingPermisoRol.getNombrePermiso().equals(dto.getNombrePermiso())) {
            if (permisoRolRepo.existsByRol_IdRolAndNombrePermiso(rol.getIdRol(), dto.getNombrePermiso())) {
                throw new RuntimeException("El permiso '" + dto.getNombrePermiso() + "' ya existe para el rol '" + rol.getNombreRol() + "'");
            }
        }

        modelMapper.map(dto, existingPermisoRol);
        existingPermisoRol.setRol(rol);
        PermisoRol updatedPermisoRol = permisoRolRepo.save(existingPermisoRol);
        return modelMapper.map(updatedPermisoRol, PermisoRolDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        permisoRolRepo.deleteById(id);
    }

    @Override
    public List<PermisoRolDTO> findByRolId(Integer rolId) {
        return permisoRolRepo.findByRol_IdRol(rolId)
                .stream()
                .map(permisoRol -> modelMapper.map(permisoRol, PermisoRolDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PermisoRolDTO addPermissionToRole(Integer rolId, String permissionName, String description) {
        Rol rol = rolRepo.findById(rolId)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        if (permisoRolRepo.existsByRol_IdRolAndNombrePermiso(rol.getIdRol(), permissionName)) {
            throw new RuntimeException("El permiso '" + permissionName + "' ya existe para el rol '" + rol.getNombreRol() + "'");
        }

        PermisoRol permisoRol = new PermisoRol();
        permisoRol.setRol(rol);
        permisoRol.setNombrePermiso(permissionName);
        permisoRol.setDescripcion(description);
        PermisoRol savedPermisoRol = permisoRolRepo.save(permisoRol);
        return modelMapper.map(savedPermisoRol, PermisoRolDTO.class);
    }

    @Override
    @Transactional
    public void removePermissionFromRole(Integer rolId, String permissionName) {
        PermisoRol permisoRol = permisoRolRepo.findByRol_IdRolAndNombrePermiso(rolId, permissionName)
                .orElseThrow(() -> new RuntimeException("El permiso '" + permissionName + "' no existe para el rol con ID " + rolId));
        permisoRolRepo.delete(permisoRol);
    }

}
