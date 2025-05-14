package com.shufitapp.shufit.service;

import java.util.List;

import com.shufitapp.shufit.dto.ProductoDTO;

public interface ProductoService {
    List<ProductoDTO> findAll();
    ProductoDTO findById(Integer id);
    ProductoDTO save(ProductoDTO dto);
    ProductoDTO update(Integer id, ProductoDTO dto);
    void deleteById(Integer id);
    List<ProductoDTO> findByNombre(String nombre);
    List<ProductoDTO> findByCategoria(String categoria);
    List<ProductoDTO> findByLowStock(Integer stockLimit);
}
