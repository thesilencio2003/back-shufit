package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Cancelacion;
import com.shufitapp.shufit.Models.Cliente;
import com.shufitapp.shufit.Models.Factura;
import com.shufitapp.shufit.Models.Membresia;
import com.shufitapp.shufit.dto.CancelacionDTO;
import com.shufitapp.shufit.repository.CancelacionRepository;
import com.shufitapp.shufit.repository.ClienteRepository;
import com.shufitapp.shufit.repository.FacturaRepository;
import com.shufitapp.shufit.repository.MembresiaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CancelacionServiceImpl implements CancelacionService {

      private final CancelacionRepository cancelacionRepo;
    private final ClienteRepository clienteRepo;
    private final FacturaRepository facturaRepo;
    private final MembresiaRepository membresiaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<CancelacionDTO> findAll() {
        return cancelacionRepo.findAll().stream()
                .map(cancelacion -> modelMapper.map(cancelacion, CancelacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CancelacionDTO findById(Integer id) {
        Cancelacion cancelacion = cancelacionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cancelación no encontrada"));
        return modelMapper.map(cancelacion, CancelacionDTO.class);
    }

    @Override
    public CancelacionDTO save(CancelacionDTO dto) {
        Cancelacion cancelacion = modelMapper.map(dto, Cancelacion.class);
        if (dto.getClienteId() != null) {
            Cliente cliente = clienteRepo.findById(dto.getClienteId())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
            cancelacion.setCliente(cliente);
        }
        if (dto.getFacturaId() != null) {
            Factura factura = facturaRepo.findById(dto.getFacturaId())
                    .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
            cancelacion.setFactura(factura);
        }
        if (dto.getMembresiaId() != null) {
            Membresia membresia = membresiaRepo.findById(dto.getMembresiaId())
                    .orElseThrow(() -> new RuntimeException("Membresía no encontrada"));
            cancelacion.setMembresia(membresia);
        }
        Cancelacion savedCancelacion = cancelacionRepo.save(cancelacion);
        return modelMapper.map(savedCancelacion, CancelacionDTO.class);
    }

    @Override
    public CancelacionDTO update(Integer id, CancelacionDTO dto) {
        Cancelacion existingCancelacion = cancelacionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cancelación no encontrada"));
        modelMapper.map(dto, existingCancelacion);
        if (dto.getClienteId() != null) {
            Cliente cliente = clienteRepo.findById(dto.getClienteId())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
            existingCancelacion.setCliente(cliente);
        } else {
            existingCancelacion.setCliente(null);
        }
        if (dto.getFacturaId() != null) {
            Factura factura = facturaRepo.findById(dto.getFacturaId())
                    .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
            existingCancelacion.setFactura(factura);
        } else {
            existingCancelacion.setFactura(null);
        }
        if (dto.getMembresiaId() != null) {
            Membresia membresia = membresiaRepo.findById(dto.getMembresiaId())
                    .orElseThrow(() -> new RuntimeException("Membresía no encontrada"));
            existingCancelacion.setMembresia(membresia);
        } else {
            existingCancelacion.setMembresia(null);
        }
        Cancelacion updatedCancelacion = cancelacionRepo.save(existingCancelacion);
        return modelMapper.map(updatedCancelacion, CancelacionDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        cancelacionRepo.deleteById(id);
    }

    @Override
    public List<CancelacionDTO> findByClienteId(Integer clienteId) {
        return cancelacionRepo.findByCliente_IdCliente(clienteId).stream()
                .map(cancelacion -> modelMapper.map(cancelacion, CancelacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CancelacionDTO> findByFacturaId(Integer facturaId) {
        return cancelacionRepo.findByFactura_IdFactura(facturaId).stream()
                .map(cancelacion -> modelMapper.map(cancelacion, CancelacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CancelacionDTO> findByMembresiaId(Integer membresiaId) {
        return cancelacionRepo.findByMembresia_IdMembresia(membresiaId).stream()
                .map(cancelacion -> modelMapper.map(cancelacion, CancelacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CancelacionDTO> findByEstado(String estadoCancelacion) {
        return cancelacionRepo.findByEstadoCancelacionIgnoreCase(estadoCancelacion).stream()
                .map(cancelacion -> modelMapper.map(cancelacion, CancelacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CancelacionDTO> findByTipo(String tipoCancelacion) {
        return cancelacionRepo.findByTipoCancelacionIgnoreCase(tipoCancelacion).stream()
                .map(cancelacion -> modelMapper.map(cancelacion, CancelacionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CancelacionDTO> findByFechaSolicitudRange(LocalDateTime start, LocalDateTime end) {
        return cancelacionRepo.findByFechaSolicitudBetween(start, end).stream()
                .map(cancelacion -> modelMapper.map(cancelacion, CancelacionDTO.class))
                .collect(Collectors.toList());
    }

}
