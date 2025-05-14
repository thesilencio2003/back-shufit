package com.shufitapp.shufit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shufitapp.shufit.dto.StockDTO;
import com.shufitapp.shufit.service.StockService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {

        private final StockService stockService;

    @GetMapping
    public ResponseEntity<List<StockDTO>> getAll() {
        return ResponseEntity.ok(stockService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(stockService.findById(id));
    }

    @PostMapping
    public ResponseEntity<StockDTO> create(@RequestBody StockDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(stockService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockDTO> update(@PathVariable Integer id, @RequestBody StockDTO dto) {
        return ResponseEntity.ok(stockService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        stockService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/producto/{productoId}")
    public ResponseEntity<List<StockDTO>> getByProductoId(@PathVariable Integer productoId) {
        return ResponseEntity.ok(stockService.findByProductoId(productoId));
    }

    @GetMapping("/bodega/{bodegaId}")
    public ResponseEntity<List<StockDTO>> getByBodegaId(@PathVariable Integer bodegaId) {
        return ResponseEntity.ok(stockService.findByBodegaId(bodegaId));
    }

    @GetMapping("/producto/{productoId}/bodega/{bodegaId}")
    public ResponseEntity<StockDTO> getByProductoIdAndBodegaId(
            @PathVariable Integer productoId,
            @PathVariable Integer bodegaId) {
        try {
            return ResponseEntity.ok(stockService.findByProductoIdAndBodegaId(productoId, bodegaId));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
