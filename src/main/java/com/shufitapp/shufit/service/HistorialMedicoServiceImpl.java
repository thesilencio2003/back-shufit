package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Cliente;
import com.shufitapp.shufit.Models.HistorialMedico;
import com.shufitapp.shufit.dto.HistorialMedicoDTO;
import com.shufitapp.shufit.repository.ClienteRepository;
import com.shufitapp.shufit.repository.HistorialMedicoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistorialMedicoServiceImpl implements HistorialMedicoService {

     private final HistorialMedicoRepository historialMedicoRepo;
    private final ClienteRepository clienteRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<HistorialMedicoDTO> findAll() {
        return historialMedicoRepo.findAll().stream()
                .map(historialMedico -> modelMapper.map(historialMedico, HistorialMedicoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public HistorialMedicoDTO findById(Integer id) {
        HistorialMedico historialMedico = historialMedicoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial médico no encontrado"));
        return modelMapper.map(historialMedico, HistorialMedicoDTO.class);
    }

    @Override
    public HistorialMedicoDTO save(HistorialMedicoDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        if (historialMedicoRepo.existsByCliente_IdCliente(cliente.getIdCliente())) {
            throw new RuntimeException("Ya existe un historial médico para el cliente con ID " + cliente.getIdCliente());
        }

        HistorialMedico historialMedico = modelMapper.map(dto, HistorialMedico.class);
        historialMedico.setCliente(cliente);
        HistorialMedico savedHistorialMedico = historialMedicoRepo.save(historialMedico);
        return modelMapper.map(savedHistorialMedico, HistorialMedicoDTO.class);
    }

    @Override
    public HistorialMedicoDTO update(Integer id, HistorialMedicoDTO dto) {
        HistorialMedico existingHistorialMedico = historialMedicoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial médico no encontrado"));

        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        if (!existingHistorialMedico.getCliente().getIdCliente().equals(cliente.getIdCliente()) &&
            historialMedicoRepo.existsByCliente_IdCliente(cliente.getIdCliente())) {
            throw new RuntimeException("Ya existe otro historial médico asociado al cliente con ID " + cliente.getIdCliente());
        }

        modelMapper.map(dto, existingHistorialMedico);
        existingHistorialMedico.setCliente(cliente);
        HistorialMedico updatedHistorialMedico = historialMedicoRepo.save(existingHistorialMedico);
        return modelMapper.map(updatedHistorialMedico, HistorialMedicoDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        historialMedicoRepo.deleteById(id);
    }

    @Override
    public HistorialMedicoDTO findByClienteId(Integer clienteId) {
        HistorialMedico historialMedico = historialMedicoRepo.findByCliente_IdCliente(clienteId)
                .orElseThrow(() -> new RuntimeException("No se encontró historial médico para el cliente con ID " + clienteId));
        return modelMapper.map(historialMedico, HistorialMedicoDTO.class);
    }
    
}
