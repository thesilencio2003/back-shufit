package com.shufitapp.shufit.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shufitapp.shufit.dto.DevolucionDTO;
import com.shufitapp.shufit.service.DevolucionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/devoluciones")
@RequiredArgsConstructor

public class DevolucionController {
private final DevolucionService devolucionService;

    @GetMapping
    public ResponseEntity<List<DevolucionDTO>> getAll() {
        return ResponseEntity.ok(devolucionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DevolucionDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(devolucionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DevolucionDTO> create(@RequestBody DevolucionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(devolucionService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DevolucionDTO> update(@PathVariable Integer id, @RequestBody DevolucionDTO dto) {
        return ResponseEntity.ok(devolucionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        devolucionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/factura/{facturaId}")
    public ResponseEntity<List<DevolucionDTO>> getByFacturaId(@PathVariable Integer facturaId) {
        return ResponseEntity.ok(devolucionService.findByFacturaId(facturaId));
    }

    @GetMapping("/estado/{estadoDevolucion}")
    public ResponseEntity<List<DevolucionDTO>> getByEstado(@PathVariable String estadoDevolucion) {
        return ResponseEntity.ok(devolucionService.findByEstado(estadoDevolucion));
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<DevolucionDTO>> getByFechaSolicitudRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(devolucionService.findByFechaSolicitudRange(start, end));
    }
}
