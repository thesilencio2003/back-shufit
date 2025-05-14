package com.shufitapp.shufit.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.PQRS;

@Repository
public interface PQRSRepository extends JpaRepository<PQRS, Integer> {

    List<PQRS> findByCliente_IdCliente(Integer clienteId);
    List<PQRS> findByTipoPqrs(String tipoPqrs);
    List<PQRS> findByEstadoPqrs(String estadoPqrs);
    List<PQRS> findByFechaCreacionBetween(LocalDateTime start, LocalDateTime end);    


}
