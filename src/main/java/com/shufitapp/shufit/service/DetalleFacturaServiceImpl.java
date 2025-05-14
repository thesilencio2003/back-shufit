package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.DetalleFactura;
import com.shufitapp.shufit.Models.Factura;
import com.shufitapp.shufit.dto.DetalleFacturaDTO;
import com.shufitapp.shufit.repository.DetalleFacturaRepository;
import com.shufitapp.shufit.repository.FacturaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    private final DetalleFacturaRepository detalleFacturaRepo;
    private final FacturaRepository facturaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<DetalleFacturaDTO> findAll() {
        return detalleFacturaRepo.findAll().stream()
                .map(detalleFactura -> modelMapper.map(detalleFactura, DetalleFacturaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DetalleFacturaDTO findById(Integer id) {
        DetalleFactura detalleFactura = detalleFacturaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de Factura no encontrado"));
        return modelMapper.map(detalleFactura, DetalleFacturaDTO.class);
    }

    @Override
    public DetalleFacturaDTO save(DetalleFacturaDTO dto) {
        Factura factura = facturaRepo.findById(dto.getIdFactura())
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        DetalleFactura detalleFactura = modelMapper.map(dto, DetalleFactura.class);
        detalleFactura.setFactura(factura);
        DetalleFactura savedDetalleFactura = detalleFacturaRepo.save(detalleFactura);
        return modelMapper.map(savedDetalleFactura, DetalleFacturaDTO.class);
    }

    @Override
    public DetalleFacturaDTO update(Integer id, DetalleFacturaDTO dto) {
        DetalleFactura existingDetalleFactura = detalleFacturaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle de Factura no encontrado"));
        Factura factura = facturaRepo.findById(dto.getIdFactura())
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        modelMapper.map(dto, existingDetalleFactura);
        existingDetalleFactura.setFactura(factura);
        DetalleFactura updatedDetalleFactura = detalleFacturaRepo.save(existingDetalleFactura);
        return modelMapper.map(updatedDetalleFactura, DetalleFacturaDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        detalleFacturaRepo.deleteById(id);
    }

    @Override
    public List<DetalleFacturaDTO> findByFacturaId(Integer facturaId) {
        return detalleFacturaRepo.findByFactura_IdFactura(facturaId).stream()
                .map(detalleFactura -> modelMapper.map(detalleFactura, DetalleFacturaDTO.class))
                .collect(Collectors.toList());
    }

}
