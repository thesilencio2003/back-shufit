package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.CabeceraFactura;
import com.shufitapp.shufit.Models.Cliente;
import com.shufitapp.shufit.Models.Factura;
import com.shufitapp.shufit.dto.FacturaDTO;
import com.shufitapp.shufit.repository.CabeceraFacturaRepository;
import com.shufitapp.shufit.repository.ClienteRepository;
import com.shufitapp.shufit.repository.FacturaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl implements FacturaService {

     private final FacturaRepository facturaRepo;
    private final ClienteRepository clienteRepo;
    private final CabeceraFacturaRepository cabeceraFacturaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<FacturaDTO> findAll() {
        return facturaRepo.findAll().stream()
                .map(factura -> modelMapper.map(factura, FacturaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public FacturaDTO findById(Integer id) {
        Factura factura = facturaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        return modelMapper.map(factura, FacturaDTO.class);
    }

    @Override
    public FacturaDTO save(FacturaDTO dto) {
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        CabeceraFactura cabeceraFactura = cabeceraFacturaRepo.findById(dto.getIdCabeceraFactura())
                .orElseThrow(() -> new RuntimeException("Cabecera de Factura no encontrada"));
        Factura factura = modelMapper.map(dto, Factura.class);
        factura.setCliente(cliente);
        factura.setCabeceraFactura(cabeceraFactura);
        Factura savedFactura = facturaRepo.save(factura);
        return modelMapper.map(savedFactura, FacturaDTO.class);
    }

    @Override
    public FacturaDTO update(Integer id, FacturaDTO dto) {
        Factura existingFactura = facturaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        CabeceraFactura cabeceraFactura = cabeceraFacturaRepo.findById(dto.getIdCabeceraFactura())
                .orElseThrow(() -> new RuntimeException("Cabecera de Factura no encontrada"));
        modelMapper.map(dto, existingFactura);
        existingFactura.setCliente(cliente);
        existingFactura.setCabeceraFactura(cabeceraFactura);
        Factura updatedFactura = facturaRepo.save(existingFactura);
        return modelMapper.map(updatedFactura, FacturaDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        facturaRepo.deleteById(id);
    }

    @Override
    public List<FacturaDTO> findByClienteId(Integer clienteId) {
        return facturaRepo.findByCliente_IdCliente(clienteId).stream()
                .map(factura -> modelMapper.map(factura, FacturaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public FacturaDTO findByCabeceraFacturaId(Integer idCabeceraFactura) {
        Factura factura = facturaRepo.findByCabeceraFactura_IdCabeceraFactura(idCabeceraFactura);
        return factura != null ? modelMapper.map(factura, FacturaDTO.class) : null;
    }

}
