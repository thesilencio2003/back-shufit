package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Devolucion;
import com.shufitapp.shufit.Models.Factura;
import com.shufitapp.shufit.dto.DevolucionDTO;
import com.shufitapp.shufit.repository.DevolucionRepository;
import com.shufitapp.shufit.repository.FacturaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DevolucionServiceImpl implements DevolucionService {

        private final DevolucionRepository devolucionRepo;
    private final FacturaRepository facturaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<DevolucionDTO> findAll() {
        return devolucionRepo.findAll().stream()
                .map(devolucion -> modelMapper.map(devolucion, DevolucionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DevolucionDTO findById(Integer id) {
        Devolucion devolucion = devolucionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Devolución no encontrada"));
        return modelMapper.map(devolucion, DevolucionDTO.class);
    }

    @Override
    public DevolucionDTO save(DevolucionDTO dto) {
        Factura factura = facturaRepo.findById(dto.getIdFactura())
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        Devolucion devolucion = modelMapper.map(dto, Devolucion.class);
        devolucion.setFactura(factura);
        Devolucion savedDevolucion = devolucionRepo.save(devolucion);
        return modelMapper.map(savedDevolucion, DevolucionDTO.class);
    }

    @Override
    public DevolucionDTO update(Integer id, DevolucionDTO dto) {
        Devolucion existingDevolucion = devolucionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Devolución no encontrada"));
        Factura factura = facturaRepo.findById(dto.getIdFactura())
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
        modelMapper.map(dto, existingDevolucion);
        existingDevolucion.setFactura(factura);
        Devolucion updatedDevolucion = devolucionRepo.save(existingDevolucion);
        return modelMapper.map(updatedDevolucion, DevolucionDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        devolucionRepo.deleteById(id);
    }

    @Override
    public List<DevolucionDTO> findByFacturaId(Integer facturaId) {
        return devolucionRepo.findByFactura_IdFactura(facturaId).stream()
                .map(devolucion -> modelMapper.map(devolucion, DevolucionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DevolucionDTO> findByEstado(String estadoDevolucion) {
        return devolucionRepo.findByEstadoDevolucionIgnoreCase(estadoDevolucion).stream()
                .map(devolucion -> modelMapper.map(devolucion, DevolucionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DevolucionDTO> findByFechaSolicitudRange(LocalDateTime start, LocalDateTime end) {
        return devolucionRepo.findByFechaSolicitudBetween(start, end).stream()
                .map(devolucion -> modelMapper.map(devolucion, DevolucionDTO.class))
                .collect(Collectors.toList());
    }

}
