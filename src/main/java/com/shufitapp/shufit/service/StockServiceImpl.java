package com.shufitapp.shufit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shufitapp.shufit.Models.Bodega;
import com.shufitapp.shufit.Models.Producto;
import com.shufitapp.shufit.Models.Stock;
import com.shufitapp.shufit.dto.StockDTO;
import com.shufitapp.shufit.repository.BodegaRepository;
import com.shufitapp.shufit.repository.ProductoRepository;
import com.shufitapp.shufit.repository.StockRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

      private final StockRepository stockRepo;
    private final ProductoRepository productoRepo;
    private final BodegaRepository bodegaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<StockDTO> findAll() {
        return stockRepo.findAll().stream()
                .map(stock -> modelMapper.map(stock, StockDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StockDTO findById(Integer id) {
        Stock stock = stockRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock no encontrado"));
        return modelMapper.map(stock, StockDTO.class);
    }

    @Override
    public StockDTO save(StockDTO dto) {
        Producto producto = productoRepo.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        Bodega bodega = bodegaRepo.findById(dto.getIdBodega())
                .orElseThrow(() -> new RuntimeException("Bodega no encontrada"));
        Stock stock = modelMapper.map(dto, Stock.class);
        stock.setProducto(producto);
        stock.setBodega(bodega);
        Stock savedStock = stockRepo.save(stock);
        return modelMapper.map(savedStock, StockDTO.class);
    }

    @Override
    public StockDTO update(Integer id, StockDTO dto) {
        Stock existingStock = stockRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock no encontrado"));
        Producto producto = productoRepo.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        Bodega bodega = bodegaRepo.findById(dto.getIdBodega())
                .orElseThrow(() -> new RuntimeException("Bodega no encontrada"));
        modelMapper.map(dto, existingStock);
        existingStock.setProducto(producto);
        existingStock.setBodega(bodega);
        Stock updatedStock = stockRepo.save(existingStock);
        return modelMapper.map(updatedStock, StockDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        stockRepo.deleteById(id);
    }

    @Override
    public List<StockDTO> findByProductoId(Integer productoId) {
        return stockRepo.findByProducto_IdProducto(productoId).stream()
                .map(stock -> modelMapper.map(stock, StockDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<StockDTO> findByBodegaId(Integer bodegaId) {
        return stockRepo.findByBodega_IdBodega(bodegaId).stream()
                .map(stock -> modelMapper.map(stock, StockDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public StockDTO findByProductoIdAndBodegaId(Integer productoId, Integer bodegaId) {
        Stock stock = stockRepo.findByProducto_IdProductoAndBodega_IdBodega(productoId, bodegaId)
                .orElseThrow(() -> new RuntimeException("Stock no encontrado para el producto y la bodega especificados"));
        return modelMapper.map(stock, StockDTO.class);
    }  

}
