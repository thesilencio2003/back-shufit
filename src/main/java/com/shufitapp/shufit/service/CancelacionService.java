package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;

import com.shufitapp.shufit.dto.CancelacionDTO;

public interface CancelacionService {

     List<CancelacionDTO> findAll();
    CancelacionDTO findById(Integer id);
    CancelacionDTO save(CancelacionDTO dto);
    CancelacionDTO update(Integer id, CancelacionDTO dto);
    void deleteById(Integer id);
    List<CancelacionDTO> findByClienteId(Integer clienteId);
    List<CancelacionDTO> findByFacturaId(Integer facturaId);
    List<CancelacionDTO> findByMembresiaId(Integer membresiaId);
    List<CancelacionDTO> findByEstado(String estadoCancelacion);
    List<CancelacionDTO> findByTipo(String tipoCancelacion);
    List<CancelacionDTO> findByFechaSolicitudRange(LocalDateTime start, LocalDateTime end);

}
