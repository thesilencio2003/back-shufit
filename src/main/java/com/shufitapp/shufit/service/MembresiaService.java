package com.shufitapp.shufit.service;

import java.time.LocalDate;
import java.util.List;

import com.shufitapp.shufit.dto.MembresiaDTO;

public interface MembresiaService {

    List<MembresiaDTO> findAll();
    MembresiaDTO findById(Integer id);
    MembresiaDTO save(MembresiaDTO dto);
    MembresiaDTO update(Integer id, MembresiaDTO dto);
    void deleteById(Integer id);
    List<MembresiaDTO> findByClientId(Integer clienteId);
    List<MembresiaDTO> findByType(String tipoMembresia);
    List<MembresiaDTO> findByStatus(String estadoMembresia);
    List<MembresiaDTO> findByStartDateBetween(LocalDate start, LocalDate end);
    List<MembresiaDTO> findByEndDateBetween(LocalDate start, LocalDate end);
    List<MembresiaDTO> findActiveByClientId(Integer clienteId);
    List<MembresiaDTO> findAllActive();
    MembresiaDTO updateStatus(Integer id, String estadoMembresia);

}
