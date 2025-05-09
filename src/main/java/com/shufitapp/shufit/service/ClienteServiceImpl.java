package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Cliente;
import com.shufitapp.shufit.Models.Persona;
import com.shufitapp.shufit.dto.ClienteDTO;
import com.shufitapp.shufit.dto.PersonaDTO;
import com.shufitapp.shufit.repository.ClienteRepository;
import com.shufitapp.shufit.repository.PersonaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepo;
    private final PersonaRepository personaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ClienteDTO> findAll() {
        return clienteRepo.findAll()
                .stream()
                .map(cliente -> convertToDto(cliente))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO findById(Integer id) {
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return convertToDto(cliente);
    }

    @Override
    public ClienteDTO save(ClienteDTO dto) {
    
            Persona persona = modelMapper.map(dto.getPersona(), Persona.class);
    persona.setFechaRegistro(LocalDateTime.now());
    persona.setFechaActualizacion(LocalDateTime.now());

    persona = personaRepo.save(persona);

    Cliente cliente = new Cliente();
    cliente.setPersona(persona);  
    cliente.setFechaInscripcion(dto.getFechaInscripcion());
    cliente.setObjetivoPrincipal(dto.getObjetivoPrincipal());
    cliente.setInformacionAdicional(dto.getInformacionAdicional());

    cliente = clienteRepo.save(cliente);


    return modelMapper.map(cliente, ClienteDTO.class);
        
    }

    @Override
    public ClienteDTO update(Integer id, ClienteDTO dto) {
        
            Cliente clienteExistente = clienteRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

    Persona persona = personaRepo.findById(clienteExistente.getPersona().getIdPersona())
            .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

    
    modelMapper.map(dto.getPersona(), persona);
    persona.setFechaActualizacion(LocalDateTime.now());
    persona = personaRepo.save(persona);

    
    clienteExistente.setPersona(persona);
    clienteExistente.setFechaInscripcion(dto.getFechaInscripcion());
    clienteExistente.setObjetivoPrincipal(dto.getObjetivoPrincipal());
    clienteExistente.setInformacionAdicional(dto.getInformacionAdicional());

    clienteExistente = clienteRepo.save(clienteExistente);

    return modelMapper.map(clienteExistente, ClienteDTO.class);
        
    }

    @Override
    public void deleteById(Integer id) {
        clienteRepo.deleteById(id);
    }


    private ClienteDTO convertToDto(Cliente cliente) {
        ClienteDTO dto = modelMapper.map(cliente, ClienteDTO.class);
        if (cliente.getPersona() != null) {
            dto.setPersona(modelMapper.map(cliente.getPersona(), PersonaDTO.class));
        }
        return dto;
    }

    private Persona convertToEntity(PersonaDTO dto) {
        Persona persona = modelMapper.map(dto, Persona.class);
        persona.setFechaRegistro(LocalDateTime.now());
        persona.setFechaActualizacion(LocalDateTime.now());
        return persona;
    }


    
}
