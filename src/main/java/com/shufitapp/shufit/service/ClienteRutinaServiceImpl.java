package com.shufitapp.shufit.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Cliente;
import com.shufitapp.shufit.Models.ClienteRutina;
import com.shufitapp.shufit.Models.ClienteRutinaId;
import com.shufitapp.shufit.Models.Rutina;
import com.shufitapp.shufit.dto.ClienteRutinaDTO;
import com.shufitapp.shufit.repository.ClienteRepository;
import com.shufitapp.shufit.repository.ClienteRutinaRepository;
import com.shufitapp.shufit.repository.RutinaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteRutinaServiceImpl implements ClienteRutinaService {

    private final ClienteRutinaRepository clienteRutinaRepo;
    private final ClienteRepository clienteRepo;
    private final RutinaRepository rutinaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ClienteRutinaDTO> findAll() {
        return clienteRutinaRepo.findAll()
                .stream()
                .map(clienteRutina -> modelMapper.map(clienteRutina, ClienteRutinaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteRutinaDTO findById(Integer clienteId, Integer rutinaId) {
        ClienteRutinaId id = new ClienteRutinaId(clienteId, rutinaId);
        ClienteRutina clienteRutina = clienteRutinaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación de rutina a cliente no encontrada"));
        return modelMapper.map(clienteRutina, ClienteRutinaDTO.class);
    }

    @Override
    public ClienteRutinaDTO save(ClienteRutinaDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Rutina rutina = rutinaRepo.findById(dto.getRutinaId())
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        if (clienteRutinaRepo.existsByClienteIdAndRutinaId(cliente.getIdCliente(), rutina.getIdRutina())) {
            throw new RuntimeException("La rutina ya está asignada a este cliente");
        }

        ClienteRutina clienteRutina = modelMapper.map(dto, ClienteRutina.class);
        clienteRutina.setClienteId(cliente.getIdCliente());
        clienteRutina.setRutinaId(rutina.getIdRutina());
        ClienteRutina savedClienteRutina = clienteRutinaRepo.save(clienteRutina);
        return modelMapper.map(savedClienteRutina, ClienteRutinaDTO.class);
    }

    @Override
    public ClienteRutinaDTO update(Integer clienteId, Integer rutinaId, ClienteRutinaDTO dto) {
        ClienteRutinaId id = new ClienteRutinaId(clienteId, rutinaId);
        ClienteRutina existingClienteRutina = clienteRutinaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación de rutina a cliente no encontrada"));

        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Rutina rutina = rutinaRepo.findById(dto.getRutinaId())
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        if (!existingClienteRutina.getClienteId().equals(cliente.getIdCliente())
                || !existingClienteRutina.getRutinaId().equals(rutina.getIdRutina())) {
            if (clienteRutinaRepo.existsByClienteIdAndRutinaId(cliente.getIdCliente(), rutina.getIdRutina())) {
                throw new RuntimeException("La rutina ya está asignada a este cliente");
            }
        }

        modelMapper.map(dto, existingClienteRutina);
        existingClienteRutina.setClienteId(cliente.getIdCliente());
        existingClienteRutina.setRutinaId(rutina.getIdRutina());
        ClienteRutina updatedClienteRutina = clienteRutinaRepo.save(existingClienteRutina);
        return modelMapper.map(updatedClienteRutina, ClienteRutinaDTO.class);
    }

    @Override
    public void deleteById(Integer clienteId, Integer rutinaId) {
        ClienteRutinaId id = new ClienteRutinaId(clienteId, rutinaId);
        clienteRutinaRepo.deleteById(id);
    }

    @Override
    public List<ClienteRutinaDTO> findByClienteId(Integer clienteId) {
        return clienteRutinaRepo.findByClienteId(clienteId)
                .stream()
                .map(clienteRutina -> modelMapper.map(clienteRutina, ClienteRutinaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ClienteRutinaDTO> findByRutinaId(Integer rutinaId) {
        return clienteRutinaRepo.findByRutinaId(rutinaId)
                .stream()
                .map(clienteRutina -> modelMapper.map(clienteRutina, ClienteRutinaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteRutinaDTO assignRoutineToClient(Integer clienteId, Integer rutinaId,
            LocalDate posibleFechaFinalizacion, String comentarios) {
        Cliente cliente = clienteRepo.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Rutina rutina = rutinaRepo.findById(rutinaId)
                .orElseThrow(() -> new RuntimeException("Rutina no encontrada"));

        if (clienteRutinaRepo.existsByClienteIdAndRutinaId(cliente.getIdCliente(), rutina.getIdRutina())) {
            throw new RuntimeException("La rutina ya está asignada a este cliente");
        }

        ClienteRutina clienteRutina = new ClienteRutina();
        clienteRutina.setClienteId(cliente.getIdCliente());
        clienteRutina.setRutinaId(rutina.getIdRutina());
        clienteRutina.setPosibleFechaFinalizacion(posibleFechaFinalizacion);
        clienteRutina.setComentarios(comentarios);
        ClienteRutina savedClienteRutina = clienteRutinaRepo.save(clienteRutina);
        return modelMapper.map(savedClienteRutina, ClienteRutinaDTO.class);
    }

    @Override
    public void unassignRoutineFromClient(Integer clienteId, Integer rutinaId) {
        ClienteRutinaId id = new ClienteRutinaId(clienteId, rutinaId);
        if (!clienteRutinaRepo.existsById(id)) {
            throw new RuntimeException("La rutina no está asignada a este cliente");
        }
        clienteRutinaRepo.deleteById(id);
    }

}
