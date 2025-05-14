package com.shufitapp.shufit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Membresia;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {

    List<Membresia> findByCliente_IdCliente(Integer clienteId);
    List<Membresia> findByTipoMembresiaIgnoreCase(String tipoMembresia);
    List<Membresia> findByEstadoMembresiaIgnoreCase(String estadoMembresia);
    List<Membresia> findByFechaInicioBetween(LocalDate start, LocalDate end);
    List<Membresia> findByFechaFinBetween(LocalDate start, LocalDate end);
    List<Membresia> findByCliente_IdClienteAndEstadoMembresiaIgnoreCase(Integer clienteId, String estadoMembresia);
    List<Membresia> findByFechaFinAfter(LocalDate date);



}
