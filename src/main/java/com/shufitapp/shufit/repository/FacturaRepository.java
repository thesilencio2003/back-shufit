package com.shufitapp.shufit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

    List<Factura> findByCliente_IdCliente(Integer clienteId);

    Factura findByCabeceraFactura_IdCabeceraFactura(Integer idCabeceraFactura);

}
