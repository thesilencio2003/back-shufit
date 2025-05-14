package com.shufitapp.shufit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByNombreIgnoreCaseContaining(String nombre);

    List<Producto> findByCategoriaIgnoreCase(String categoria);

    List<Producto> findByStockLessThan(Integer stock);

}
