package com.shufitapp.shufit.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shufitapp.shufit.Models.Devolucion;

public interface DevolucionRepository extends JpaRepository<Devolucion, Integer> {

    List<Devolucion> findByFactura_IdFactura(Integer facturaId);
    List<Devolucion> findByEstadoDevolucionIgnoreCase(String estadoDevolucion);
    List<Devolucion> findByFechaSolicitudBetween(LocalDateTime start, LocalDateTime end);

}
