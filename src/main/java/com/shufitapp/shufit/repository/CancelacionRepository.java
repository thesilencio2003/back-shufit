package com.shufitapp.shufit.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Cancelacion;

@Repository
public interface CancelacionRepository extends JpaRepository<Cancelacion, Integer> {
    List<Cancelacion> findByCliente_IdCliente(Integer clienteId);

    List<Cancelacion> findByFactura_IdFactura(Integer facturaId);

    List<Cancelacion> findByMembresia_IdMembresia(Integer membresiaId);

    List<Cancelacion> findByEstadoCancelacionIgnoreCase(String estadoCancelacion);

    List<Cancelacion> findByTipoCancelacionIgnoreCase(String tipoCancelacion);

    List<Cancelacion> findByFechaSolicitudBetween(LocalDateTime start, LocalDateTime end);
}
