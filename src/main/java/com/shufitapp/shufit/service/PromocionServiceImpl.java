package com.shufitapp.shufit.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Promocion;
import com.shufitapp.shufit.dto.PromocionDTO;
import com.shufitapp.shufit.repository.PromocionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PromocionServiceImpl implements PromocionService {

        private final PromocionRepository promocionRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<PromocionDTO> findAll() {
        return promocionRepo.findAll().stream()
                .map(promocion -> modelMapper.map(promocion, PromocionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PromocionDTO findById(Integer id) {
        Promocion promocion = promocionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Promoción no encontrada"));
        return modelMapper.map(promocion, PromocionDTO.class);
    }

    @Override
    public PromocionDTO save(PromocionDTO dto) {
        Promocion promocion = modelMapper.map(dto, Promocion.class);
        Promocion savedPromocion = promocionRepo.save(promocion);
        return modelMapper.map(savedPromocion, PromocionDTO.class);
    }

    @Override
    public PromocionDTO update(Integer id, PromocionDTO dto) {
        Promocion existingPromocion = promocionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Promoción no encontrada"));
        modelMapper.map(dto, existingPromocion);
        Promocion updatedPromocion = promocionRepo.save(existingPromocion);
        return modelMapper.map(updatedPromocion, PromocionDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        promocionRepo.deleteById(id);
    }

    @Override
    public PromocionDTO findByCodigo(String codigoPromocion) {
        return promocionRepo.findByCodigoPromocionIgnoreCase(codigoPromocion)
                .map(promocion -> modelMapper.map(promocion, PromocionDTO.class))
                .orElse(null);
    }

    @Override
    public List<PromocionDTO> findActivas() {
        return promocionRepo.findByFechaFinAfter(LocalDate.now()).stream()
                .map(promocion -> modelMapper.map(promocion, PromocionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PromocionDTO> findByAplicaA(String aplicaA) {
        return promocionRepo.findByAplicaAIgnoreCase(aplicaA).stream()
                .map(promocion -> modelMapper.map(promocion, PromocionDTO.class))
                .collect(Collectors.toList());
    }

}
