package com.shufitapp.shufit.service;

import java.time.LocalDate;
import java.util.List;

import com.shufitapp.shufit.dto.ClienteRutinaDTO;

public interface ClienteRutinaService {

    List<ClienteRutinaDTO> findAll();

    ClienteRutinaDTO findById(Integer clienteId, Integer rutinaId);

    ClienteRutinaDTO save(ClienteRutinaDTO dto);

    ClienteRutinaDTO update(Integer clienteId, Integer rutinaId, ClienteRutinaDTO dto);

    void deleteById(Integer clienteId, Integer rutinaId);

    List<ClienteRutinaDTO> findByClienteId(Integer clienteId);

    List<ClienteRutinaDTO> findByRutinaId(Integer rutinaId);

    ClienteRutinaDTO assignRoutineToClient(Integer clienteId, Integer rutinaId, LocalDate posibleFechaFinalizacion,
            String comentarios);

    void unassignRoutineFromClient(Integer clienteId, Integer rutinaId);

}
