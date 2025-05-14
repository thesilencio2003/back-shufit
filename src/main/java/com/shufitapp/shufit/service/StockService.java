package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.StockDTO;

public interface StockService {

    List<StockDTO> findAll();
    StockDTO findById(Integer id);
    StockDTO save(StockDTO dto);
    StockDTO update(Integer id, StockDTO dto);
    void deleteById(Integer id);
    List<StockDTO> findByProductoId(Integer productoId);
    List<StockDTO> findByBodegaId(Integer bodegaId);
    StockDTO findByProductoIdAndBodegaId(Integer productoId, Integer bodegaId);

}
