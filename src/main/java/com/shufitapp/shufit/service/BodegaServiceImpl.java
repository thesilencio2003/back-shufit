package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Bodega;
import com.shufitapp.shufit.dto.BodegaDTO;
import com.shufitapp.shufit.repository.BodegaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BodegaServiceImpl implements BodegaService {

      private final BodegaRepository bodegaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<BodegaDTO> findAll() {
        return bodegaRepo.findAll().stream()
                .map(bodega -> modelMapper.map(bodega, BodegaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BodegaDTO findById(Integer id) {
        Bodega bodega = bodegaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bodega no encontrada"));
        return modelMapper.map(bodega, BodegaDTO.class);
    }

    @Override
    public BodegaDTO save(BodegaDTO dto) {
        Bodega bodega = modelMapper.map(dto, Bodega.class);
        Bodega savedBodega = bodegaRepo.save(bodega);
        return modelMapper.map(savedBodega, BodegaDTO.class);
    }

    @Override
    public BodegaDTO update(Integer id, BodegaDTO dto) {
        Bodega existingBodega = bodegaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bodega no encontrada"));
        modelMapper.map(dto, existingBodega);
        Bodega updatedBodega = bodegaRepo.save(existingBodega);
        return modelMapper.map(updatedBodega, BodegaDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        bodegaRepo.deleteById(id);
    }

    @Override
    public List<BodegaDTO> findByNombre(String nombre) {
        return bodegaRepo.findByNombreIgnoreCaseContaining(nombre).stream()
                .map(bodega -> modelMapper.map(bodega, BodegaDTO.class))
                .collect(Collectors.toList());
    }

}
