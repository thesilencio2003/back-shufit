package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Persona;
import com.shufitapp.shufit.Models.Rol;
import com.shufitapp.shufit.Models.Usuario;
import com.shufitapp.shufit.dto.PersonaDTO;
import com.shufitapp.shufit.dto.UsuarioDTO;
import com.shufitapp.shufit.repository.PersonaRepository;
import com.shufitapp.shufit.repository.RolRepository;
import com.shufitapp.shufit.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepo;
    private final PersonaRepository personaRepo;
    private final RolRepository rolRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<UsuarioDTO> findAll() {
        return usuarioRepo.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO findById(Integer id) {
        Usuario usuario = usuarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return convertToDto(usuario);
    }

   @Override
    public UsuarioDTO save(UsuarioDTO dto) {
        if (usuarioRepo.existsByNombreUsuario(dto.getNombreUsuario())) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }

        Persona persona = personaRepo.findById(dto.getPersona().getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Rol rol = null;
        if (dto.getRolId() != null) {
            rol = rolRepo.findById(dto.getRolId()) 
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        } 

        Usuario usuario = new Usuario();
        usuario.setPersona(persona);
        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setContrasena(dto.getContrasena());
        usuario.setRol(rol);
        usuario.setFechaCreacion(LocalDateTime.now());
        usuario.setFechaActualizacion(LocalDateTime.now());

        Usuario savedUsuario = usuarioRepo.save(usuario);
        return convertToDto(savedUsuario);
    }

  @Override
    public UsuarioDTO update(Integer id, UsuarioDTO dto) {
        Usuario existingUsuario = usuarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Persona persona = personaRepo.findById(dto.getPersona().getIdPersona())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        Rol rol = null;
        if (dto.getRolId() != null) {
            rol = rolRepo.findById(dto.getRolId())
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        } 

        existingUsuario.setPersona(persona);
        existingUsuario.setNombreUsuario(dto.getNombreUsuario());
        existingUsuario.setContrasena(dto.getContrasena());
        existingUsuario.setRol(rol);
        existingUsuario.setFechaActualizacion(LocalDateTime.now());

        Usuario updatedUsuario = usuarioRepo.save(existingUsuario);
        return convertToDto(updatedUsuario);
    }

    @Override
    public void deleteById(Integer id) {
        usuarioRepo.deleteById(id);
    }

    private UsuarioDTO convertToDto(Usuario usuario) {
        UsuarioDTO dto = modelMapper.map(usuario, UsuarioDTO.class);
        if (usuario.getPersona() != null) {
            dto.setPersona(modelMapper.map(usuario.getPersona(), PersonaDTO.class));
        }
        if (usuario.getRol() != null) {
            dto.setRolId(usuario.getRol().getIdRol());
        }
        return dto;
    }
}
