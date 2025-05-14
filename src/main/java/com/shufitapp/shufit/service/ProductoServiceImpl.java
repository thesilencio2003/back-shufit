package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Producto;
import com.shufitapp.shufit.dto.ProductoDTO;
import com.shufitapp.shufit.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
 private final ProductoRepository productoRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<ProductoDTO> findAll() {
        return productoRepo.findAll().stream()
                .map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO findById(Integer id) {
        Producto producto = productoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return modelMapper.map(producto, ProductoDTO.class);
    }

    @Override
    public ProductoDTO save(ProductoDTO dto) {
        Producto producto = modelMapper.map(dto, Producto.class);
        Producto savedProducto = productoRepo.save(producto);
        return modelMapper.map(savedProducto, ProductoDTO.class);
    }

    @Override
    public ProductoDTO update(Integer id, ProductoDTO dto) {
        Producto existingProducto = productoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        modelMapper.map(dto, existingProducto);
        Producto updatedProducto = productoRepo.save(existingProducto);
        return modelMapper.map(updatedProducto, ProductoDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        productoRepo.deleteById(id);
    }

    @Override
    public List<ProductoDTO> findByNombre(String nombre) {
        return productoRepo.findByNombreIgnoreCaseContaining(nombre).stream()
                .map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductoDTO> findByCategoria(String categoria) {
        return productoRepo.findByCategoriaIgnoreCase(categoria).stream()
                .map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductoDTO> findByLowStock(Integer stockLimit) {
        return productoRepo.findByStockLessThan(stockLimit).stream()
                .map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .collect(Collectors.toList());
    }
}
