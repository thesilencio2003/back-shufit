package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Cliente;
import com.shufitapp.shufit.Models.PQRS;
import com.shufitapp.shufit.dto.PQRSDTO;
import com.shufitapp.shufit.repository.ClienteRepository;
import com.shufitapp.shufit.repository.PQRSRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PQRSServiceImpl implements PQRSService {

     private final PQRSRepository pqrsRepo;
    private final ClienteRepository clienteRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<PQRSDTO> findAll() {
        return pqrsRepo.findAll().stream().map(pqrs -> modelMapper.map(pqrs, PQRSDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PQRSDTO findById(Integer id) {
        PQRS pqrs = pqrsRepo.findById(id).orElseThrow(() -> new RuntimeException("PQRS no encontrada"));
        return modelMapper.map(pqrs, PQRSDTO.class);
    }

    @Override
    public PQRSDTO save(PQRSDTO dto) {
        PQRS pqrs = modelMapper.map(dto, PQRS.class);
        if (dto.getClienteId() != null) {
            Cliente cliente = clienteRepo.findById(dto.getClienteId()).orElse(null);
            pqrs.setCliente(cliente);
        }
        PQRS savedPqrs = pqrsRepo.save(pqrs);
        return modelMapper.map(savedPqrs, PQRSDTO.class);
    }

    @Override
    public PQRSDTO update(Integer id, PQRSDTO dto) {
        PQRS existingPqrs = pqrsRepo.findById(id).orElseThrow(() -> new RuntimeException("PQRS no encontrada"));
        modelMapper.map(dto, existingPqrs);
        if (dto.getClienteId() != null) {
            Cliente cliente = clienteRepo.findById(dto.getClienteId()).orElse(null);
            existingPqrs.setCliente(cliente);
        } else {
            existingPqrs.setCliente(null);
        }
        PQRS updatedPqrs = pqrsRepo.save(existingPqrs);
        return modelMapper.map(updatedPqrs, PQRSDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        pqrsRepo.deleteById(id);
    }

    @Override
    public List<PQRSDTO> findByClientId(Integer clienteId) {
        return pqrsRepo.findByCliente_IdCliente(clienteId).stream().map(pqrs -> modelMapper.map(pqrs, PQRSDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PQRSDTO> findByType(String tipoPqrs) {
        return pqrsRepo.findByTipoPqrs(tipoPqrs).stream().map(pqrs -> modelMapper.map(pqrs, PQRSDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PQRSDTO> findByStatus(String estadoPqrs) {
        return pqrsRepo.findByEstadoPqrs(estadoPqrs).stream().map(pqrs -> modelMapper.map(pqrs, PQRSDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PQRSDTO> findByCreationDateBetween(LocalDateTime start, LocalDateTime end) {
        return pqrsRepo.findByFechaCreacionBetween(start, end).stream().map(pqrs -> modelMapper.map(pqrs, PQRSDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PQRSDTO reply(Integer id, String respuesta) {
        PQRS pqrs = pqrsRepo.findById(id).orElseThrow(() -> new RuntimeException("PQRS no encontrada"));
        pqrs.setRespuesta(respuesta);
        pqrs.setFechaRespuesta(LocalDateTime.now());
        pqrs.setEstadoPqrs("Respondido");
        PQRS updatedPqrs = pqrsRepo.save(pqrs);
        return modelMapper.map(updatedPqrs, PQRSDTO.class);
    }


}
