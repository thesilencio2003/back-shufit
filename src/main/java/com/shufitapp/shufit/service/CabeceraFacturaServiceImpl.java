package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.CabeceraFactura;
import com.shufitapp.shufit.dto.CabeceraFacturaDTO;
import com.shufitapp.shufit.repository.CabeceraFacturaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CabeceraFacturaServiceImpl implements CabeceraFacturaService {

    private final CabeceraFacturaRepository cabeceraFacturaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<CabeceraFacturaDTO> findAll() {
        return cabeceraFacturaRepo.findAll().stream()
                .map(cabeceraFactura -> modelMapper.map(cabeceraFactura, CabeceraFacturaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CabeceraFacturaDTO findById(Integer id) {
        CabeceraFactura cabeceraFactura = cabeceraFacturaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cabecera de Factura no encontrada"));
        return modelMapper.map(cabeceraFactura, CabeceraFacturaDTO.class);
    }

    @Override
    public CabeceraFacturaDTO save(CabeceraFacturaDTO dto) {
        CabeceraFactura cabeceraFactura = modelMapper.map(dto, CabeceraFactura.class);
        CabeceraFactura savedCabeceraFactura = cabeceraFacturaRepo.save(cabeceraFactura);
        return modelMapper.map(savedCabeceraFactura, CabeceraFacturaDTO.class);
    }

    @Override
    public CabeceraFacturaDTO update(Integer id, CabeceraFacturaDTO dto) {
        CabeceraFactura existingCabeceraFactura = cabeceraFacturaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cabecera de Factura no encontrada"));
        modelMapper.map(dto, existingCabeceraFactura);
        CabeceraFactura updatedCabeceraFactura = cabeceraFacturaRepo.save(existingCabeceraFactura);
        return modelMapper.map(updatedCabeceraFactura, CabeceraFacturaDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        cabeceraFacturaRepo.deleteById(id);
    }
}
