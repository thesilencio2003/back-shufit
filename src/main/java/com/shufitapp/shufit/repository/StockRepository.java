package com.shufitapp.shufit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shufitapp.shufit.Models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findByProducto_IdProducto(Integer productoId);

    List<Stock> findByBodega_IdBodega(Integer bodegaId);

    Optional<Stock> findByProducto_IdProductoAndBodega_IdBodega(Integer productoId, Integer bodegaId);

}
