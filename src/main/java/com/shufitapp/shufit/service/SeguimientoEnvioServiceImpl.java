package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Factura;
import com.shufitapp.shufit.Models.SeguimientoEnvio;
import com.shufitapp.shufit.dto.SeguimientoEnvioDTO;
import com.shufitapp.shufit.repository.FacturaRepository;
import com.shufitapp.shufit.repository.SeguimientoEnvioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeguimientoEnvioServiceImpl implements SeguimientoEnvioService {

        private final SeguimientoEnvioRepository seguimientoEnvioRepo;
    private final FacturaRepository facturaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<SeguimientoEnvioDTO> findAll() {
        return seguimientoEnvioRepo.findAll().stream()
                .map(seguimiento -> modelMapper.map(seguimiento, SeguimientoEnvioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SeguimientoEnvioDTO findById(Integer id) {
        SeguimientoEnvio seguimiento = seguimientoEnvioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Seguimiento de envío no encontrado"));
        return modelMapper.map(seguimiento, SeguimientoEnvioDTO.class);
    }

    @Override
    public SeguimientoEnvioDTO save(SeguimientoEnvioDTO dto) {
        Factura factura = facturaRepo.findById(dto.getIdFactura())
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        SeguimientoEnvio seguimientoEnvio = modelMapper.map(dto, SeguimientoEnvio.class);
        seguimientoEnvio.setFactura(factura);
        SeguimientoEnvio savedSeguimiento = seguimientoEnvioRepo.save(seguimientoEnvio);
        return modelMapper.map(savedSeguimiento, SeguimientoEnvioDTO.class);
    }

    @Override
    public SeguimientoEnvioDTO update(Integer id, SeguimientoEnvioDTO dto) {
        SeguimientoEnvio existingSeguimiento = seguimientoEnvioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Seguimiento de envío no encontrado"));
        Factura factura = facturaRepo.findById(dto.getIdFactura())
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        modelMapper.map(dto, existingSeguimiento);
        existingSeguimiento.setFactura(factura);
        SeguimientoEnvio updatedSeguimiento = seguimientoEnvioRepo.save(existingSeguimiento);
        return modelMapper.map(updatedSeguimiento, SeguimientoEnvioDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        seguimientoEnvioRepo.deleteById(id);
    }

    @Override
    public SeguimientoEnvioDTO findByFacturaId(Integer facturaId) {
        return seguimientoEnvioRepo.findByFactura_IdFactura(facturaId)
                .map(seguimiento -> modelMapper.map(seguimiento, SeguimientoEnvioDTO.class))
                .orElse(null);
    }

    @Override
    public SeguimientoEnvioDTO findByNumeroGuia(String numeroGuia) {
        return seguimientoEnvioRepo.findByNumeroGuiaIgnoreCase(numeroGuia)
                .map(seguimiento -> modelMapper.map(seguimiento, SeguimientoEnvioDTO.class))
                .orElse(null);
    }

    @Override
    public List<SeguimientoEnvioDTO> findByEstadoEnvio(String estadoEnvio) {
        return seguimientoEnvioRepo.findByEstadoEnvioIgnoreCase(estadoEnvio).stream()
                .map(seguimiento -> modelMapper.map(seguimiento, SeguimientoEnvioDTO.class))
                .collect(Collectors.toList());
    }

}
