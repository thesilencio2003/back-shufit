package com.shufitapp.shufit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.SeguimientoEnvio;

@Repository
public interface SeguimientoEnvioRepository extends JpaRepository<SeguimientoEnvio, Integer> {

    Optional<SeguimientoEnvio> findByFactura_IdFactura(Integer facturaId);
    Optional<SeguimientoEnvio> findByNumeroGuiaIgnoreCase(String numeroGuia);
    List<SeguimientoEnvio> findByEstadoEnvioIgnoreCase(String estadoEnvio);

}
