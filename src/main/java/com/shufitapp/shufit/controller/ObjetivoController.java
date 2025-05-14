package com.shufitapp.shufit.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shufitapp.shufit.dto.ObjetivoDTO;
import com.shufitapp.shufit.service.ObjetivoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/objetivos")
@RequiredArgsConstructor
public class ObjetivoController {

    private final ObjetivoService objetivoService;

    @GetMapping
    public ResponseEntity<List<ObjetivoDTO>> getAll() {
        return ResponseEntity.ok(objetivoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjetivoDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(objetivoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ObjetivoDTO> create(@RequestBody ObjetivoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(objetivoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObjetivoDTO> update(@PathVariable Integer id, @RequestBody ObjetivoDTO dto) {
        return ResponseEntity.ok(objetivoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        objetivoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<ObjetivoDTO>> getByClientId(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(objetivoService.findByClientId(clienteId));
    }

    @GetMapping("/tipo/{tipoObjetivo}")
    public ResponseEntity<List<ObjetivoDTO>> getByType(@PathVariable String tipoObjetivo) {
        return ResponseEntity.ok(objetivoService.findByType(tipoObjetivo));
    }

    @GetMapping("/estado/{estadoObjetivo}")
    public ResponseEntity<List<ObjetivoDTO>> getByStatus(@PathVariable String estadoObjetivo) {
        return ResponseEntity.ok(objetivoService.findByStatus(estadoObjetivo));
    }

    @GetMapping("/fecha-inicio")
    public ResponseEntity<List<ObjetivoDTO>> getByStartDateBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return ResponseEntity.ok(objetivoService.findByStartDateBetween(start, end));
    }

    @GetMapping("/fecha-fin")
    public ResponseEntity<List<ObjetivoDTO>> getByEndDateBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return ResponseEntity.ok(objetivoService.findByEndDateBetween(start, end));
    }

    @GetMapping("/cliente/{clienteId}/activo")
    public ResponseEntity<List<ObjetivoDTO>> getActiveByClientId(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(objetivoService.findActiveByClientId(clienteId));
    }

    @PatchMapping("/{id}/progreso")
    public ResponseEntity<ObjetivoDTO> updateProgress(@PathVariable Integer id, @RequestParam Double progreso) {
        return ResponseEntity.ok(objetivoService.updateProgress(id, progreso));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<ObjetivoDTO> updateStatus(@PathVariable Integer id, @RequestParam String estadoObjetivo) {
        return ResponseEntity.ok(objetivoService.updateStatus(id, estadoObjetivo));
    }
}
