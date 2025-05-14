package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;

import com.shufitapp.shufit.dto.PQRSDTO;

public interface PQRSService {

    List<PQRSDTO> findAll();

    PQRSDTO findById(Integer id);

    PQRSDTO save(PQRSDTO dto);

    PQRSDTO update(Integer id, PQRSDTO dto);

    void deleteById(Integer id);

    List<PQRSDTO> findByClientId(Integer clienteId);

    List<PQRSDTO> findByType(String tipoPqrs);

    List<PQRSDTO> findByStatus(String estadoPqrs);

    List<PQRSDTO> findByCreationDateBetween(LocalDateTime start, LocalDateTime end);

    PQRSDTO reply(Integer id, String respuesta);

}
