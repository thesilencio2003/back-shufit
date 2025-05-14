package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Contacto;
import com.shufitapp.shufit.dto.ContactoDTO;
import com.shufitapp.shufit.repository.ContactoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactoServiceImpl implements ContactoService {

    private final ContactoRepository contactoRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ContactoDTO> findAll() {
        return contactoRepo.findAll().stream().map(contacto -> modelMapper.map(contacto, ContactoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ContactoDTO findById(Integer id) {
        Contacto contacto = contactoRepo.findById(id).orElseThrow(() -> new RuntimeException("Contacto no encontrado"));
        return modelMapper.map(contacto, ContactoDTO.class);
    }

    @Override
    public ContactoDTO save(ContactoDTO dto) {
        Contacto contacto = modelMapper.map(dto, Contacto.class);
        Contacto savedContacto = contactoRepo.save(contacto);
        return modelMapper.map(savedContacto, ContactoDTO.class);
    }

    @Override
    public ContactoDTO update(Integer id, ContactoDTO dto) {
        Contacto existingContacto = contactoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Contacto no encontrado"));
        modelMapper.map(dto, existingContacto);
        Contacto updatedContacto = contactoRepo.save(existingContacto);
        return modelMapper.map(updatedContacto, ContactoDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        contactoRepo.deleteById(id);
    }

    @Override
    public List<ContactoDTO> findByNombre(String nombre) {
        return contactoRepo.findByNombreContainingIgnoreCase(nombre).stream()
                .map(contacto -> modelMapper.map(contacto, ContactoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ContactoDTO> findByEmail(String email) {
        return contactoRepo.findByEmailContainingIgnoreCase(email).stream()
                .map(contacto -> modelMapper.map(contacto, ContactoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ContactoDTO> findByAsunto(String asunto) {
        return contactoRepo.findByAsuntoContainingIgnoreCase(asunto).stream()
                .map(contacto -> modelMapper.map(contacto, ContactoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ContactoDTO> findByEstado(String estadoContacto) {
        return contactoRepo.findByEstadoContacto(estadoContacto).stream()
                .map(contacto -> modelMapper.map(contacto, ContactoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ContactoDTO> findByFechaContactoBetween(LocalDateTime start, LocalDateTime end) {
        return contactoRepo.findByFechaContactoBetween(start, end).stream()
                .map(contacto -> modelMapper.map(contacto, ContactoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ContactoDTO updateEstado(Integer id, String estadoContacto) {
        Contacto contacto = contactoRepo.findById(id).orElseThrow(() -> new RuntimeException("Contacto no encontrado"));
        contacto.setEstadoContacto(estadoContacto);
        Contacto updatedContacto = contactoRepo.save(contacto);
        return modelMapper.map(updatedContacto, ContactoDTO.class);
    }

}
