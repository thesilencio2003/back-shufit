package com.shufitapp.shufit.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shufitapp.shufit.dto.EstadisticaDTO;
import com.shufitapp.shufit.service.EstadisticaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/estadisticas")
@RequiredArgsConstructor
public class EstadisticaController {
    private final EstadisticaService estadisticaService;

    @GetMapping
    public ResponseEntity<List<EstadisticaDTO>> getAll() {
        return ResponseEntity.ok(estadisticaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadisticaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(estadisticaService.findById(id));
    }

    @GetMapping("/rango-fecha")
    public ResponseEntity<List<EstadisticaDTO>> getByFechaCalculoRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(estadisticaService.findByFechaCalculoRange(start, end));
    }

    @GetMapping("/latest")
    public ResponseEntity<EstadisticaDTO> getLatestStatistics() {
        EstadisticaDTO latest = estadisticaService.getLatestStatistics();
        return ResponseEntity.ok(latest);
    }
}
