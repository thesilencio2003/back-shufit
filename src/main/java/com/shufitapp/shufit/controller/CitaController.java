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

import com.shufitapp.shufit.dto.CitaDTO;
import com.shufitapp.shufit.service.CitaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/citas")
@RequiredArgsConstructor
public class CitaController {

     private final CitaService citaService;

    @GetMapping
    public ResponseEntity<List<CitaDTO>> getAll() {
        return ResponseEntity.ok(citaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(citaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CitaDTO> create(@RequestBody CitaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(citaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaDTO> update(@PathVariable Integer id, @RequestBody CitaDTO dto) {
        return ResponseEntity.ok(citaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        citaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<CitaDTO>> getByClienteId(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(citaService.findByClienteId(clienteId));
    }

    @GetMapping("/entrenador/{entrenadorId}")
    public ResponseEntity<List<CitaDTO>> getByEntrenadorId(@PathVariable Integer entrenadorId) {
        return ResponseEntity.ok(citaService.findByEntrenadorId(entrenadorId));
    }

    @GetMapping("/nutricionista/{nutricionistaId}")
    public ResponseEntity<List<CitaDTO>> getByNutricionistaId(@PathVariable Integer nutricionistaId) {
        return ResponseEntity.ok(citaService.findByNutricionistaId(nutricionistaId));
    }

    @GetMapping("/rango-fechas")
    public ResponseEntity<List<CitaDTO>> getByFechaHoraBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(citaService.findByFechaHoraBetween(start, end));
    }

    @GetMapping("/tipo/{tipoCita}")
    public ResponseEntity<List<CitaDTO>> getByTipoCita(@PathVariable String tipoCita) {
        return ResponseEntity.ok(citaService.findByTipoCita(tipoCita));
    }

    @GetMapping("/estado/{estadoCita}")
    public ResponseEntity<List<CitaDTO>> getByEstadoCita(@PathVariable String estadoCita) {
        return ResponseEntity.ok(citaService.findByEstadoCita(estadoCita));
    }   

}
