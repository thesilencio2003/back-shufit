package com.shufitapp.shufit.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

    List<Contacto> findByNombreContainingIgnoreCase(String nombre);

    List<Contacto> findByEmailContainingIgnoreCase(String email);

    List<Contacto> findByAsuntoContainingIgnoreCase(String asunto);

    List<Contacto> findByEstadoContacto(String estadoContacto);

    List<Contacto> findByFechaContactoBetween(LocalDateTime start, LocalDateTime end);

}
