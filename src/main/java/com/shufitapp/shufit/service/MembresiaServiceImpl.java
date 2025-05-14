package com.shufitapp.shufit.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Cliente;
import com.shufitapp.shufit.Models.Membresia;
import com.shufitapp.shufit.dto.MembresiaDTO;
import com.shufitapp.shufit.repository.ClienteRepository;
import com.shufitapp.shufit.repository.MembresiaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MembresiaServiceImpl implements MembresiaService {

    private final MembresiaRepository membresiaRepo;
    private final ClienteRepository clienteRepo;
    private final ModelMapper modelMapper;

     @Override
    public List<MembresiaDTO> findAll() {
        return membresiaRepo.findAll().stream()
                .map(membresia -> modelMapper.map(membresia, MembresiaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MembresiaDTO findById(Integer id) {
        Membresia membresia = membresiaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Membresía no encontrada"));
        return modelMapper.map(membresia, MembresiaDTO.class);
    }

    @Override
    public MembresiaDTO save(MembresiaDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        Membresia membresia = modelMapper.map(dto, Membresia.class);
        membresia.setCliente(cliente);
        Membresia savedMembresia = membresiaRepo.save(membresia);
        return modelMapper.map(savedMembresia, MembresiaDTO.class);
    }

    @Override
    public MembresiaDTO update(Integer id, MembresiaDTO dto) {
        Membresia existingMembresia = membresiaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Membresía no encontrada"));
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        modelMapper.map(dto, existingMembresia);
        existingMembresia.setCliente(cliente);
        Membresia updatedMembresia = membresiaRepo.save(existingMembresia);
        return modelMapper.map(updatedMembresia, MembresiaDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        membresiaRepo.deleteById(id);
    }

    @Override
    public List<MembresiaDTO> findByClientId(Integer clienteId) {
        return membresiaRepo.findByCliente_IdCliente(clienteId).stream()
                .map(membresia -> modelMapper.map(membresia, MembresiaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MembresiaDTO> findByType(String tipoMembresia) {
        return membresiaRepo.findByTipoMembresiaIgnoreCase(tipoMembresia).stream()
                .map(membresia -> modelMapper.map(membresia, MembresiaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MembresiaDTO> findByStatus(String estadoMembresia) {
        return membresiaRepo.findByEstadoMembresiaIgnoreCase(estadoMembresia).stream()
                .map(membresia -> modelMapper.map(membresia, MembresiaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MembresiaDTO> findByStartDateBetween(LocalDate start, LocalDate end) {
        return membresiaRepo.findByFechaInicioBetween(start, end).stream()
                .map(membresia -> modelMapper.map(membresia, MembresiaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MembresiaDTO> findByEndDateBetween(LocalDate start, LocalDate end) {
        return membresiaRepo.findByFechaFinBetween(start, end).stream()
                .map(membresia -> modelMapper.map(membresia, MembresiaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MembresiaDTO> findActiveByClientId(Integer clienteId) {
        return membresiaRepo.findByCliente_IdClienteAndEstadoMembresiaIgnoreCase(clienteId, "Activa").stream()
                .map(membresia -> modelMapper.map(membresia, MembresiaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MembresiaDTO> findAllActive() {
        return membresiaRepo.findByFechaFinAfter(LocalDate.now()).stream()
                .map(membresia -> modelMapper.map(membresia, MembresiaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MembresiaDTO updateStatus(Integer id, String estadoMembresia) {
        Membresia membresia = membresiaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Membresía no encontrada"));
        membresia.setEstadoMembresia(estadoMembresia);
        Membresia updatedMembresia = membresiaRepo.save(membresia);
        return modelMapper.map(updatedMembresia, MembresiaDTO.class);
    }

}
