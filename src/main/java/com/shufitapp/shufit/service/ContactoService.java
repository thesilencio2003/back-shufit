package com.shufitapp.shufit.service;

import java.time.LocalDateTime;
import java.util.List;

import com.shufitapp.shufit.dto.ContactoDTO;

public interface ContactoService {

    List<ContactoDTO> findAll();

    ContactoDTO findById(Integer id);

    ContactoDTO save(ContactoDTO dto);

    ContactoDTO update(Integer id, ContactoDTO dto);

    void deleteById(Integer id);

    List<ContactoDTO> findByNombre(String nombre);

    List<ContactoDTO> findByEmail(String email);

    List<ContactoDTO> findByAsunto(String asunto);

    List<ContactoDTO> findByEstado(String estadoContacto);

    List<ContactoDTO> findByFechaContactoBetween(LocalDateTime start, LocalDateTime end);

    ContactoDTO updateEstado(Integer id, String estadoContacto);

}
