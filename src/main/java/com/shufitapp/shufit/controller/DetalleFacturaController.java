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

import com.shufitapp.shufit.dto.DetalleFacturaDTO;
import com.shufitapp.shufit.service.DetalleFacturaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/detalles-factura")
@RequiredArgsConstructor
public class DetalleFacturaController {

     private final DetalleFacturaService detalleFacturaService;

    @GetMapping
    public ResponseEntity<List<DetalleFacturaDTO>> getAll() {
        return ResponseEntity.ok(detalleFacturaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleFacturaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(detalleFacturaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DetalleFacturaDTO> create(@RequestBody DetalleFacturaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleFacturaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleFacturaDTO> update(@PathVariable Integer id, @RequestBody DetalleFacturaDTO dto) {
        return ResponseEntity.ok(detalleFacturaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        detalleFacturaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/factura/{facturaId}")
    public ResponseEntity<List<DetalleFacturaDTO>> getByFacturaId(@PathVariable Integer facturaId) {
        return ResponseEntity.ok(detalleFacturaService.findByFacturaId(facturaId));
    }
}
