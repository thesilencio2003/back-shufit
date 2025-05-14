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

import com.shufitapp.shufit.dto.MembresiaDTO;
import com.shufitapp.shufit.service.MembresiaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/membresias")
@RequiredArgsConstructor
public class MembresiaController {

      private final MembresiaService membresiaService;

    @GetMapping
    public ResponseEntity<List<MembresiaDTO>> getAll() {
        return ResponseEntity.ok(membresiaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembresiaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(membresiaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MembresiaDTO> create(@RequestBody MembresiaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(membresiaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembresiaDTO> update(@PathVariable Integer id, @RequestBody MembresiaDTO dto) {
        return ResponseEntity.ok(membresiaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        membresiaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<MembresiaDTO>> getByClientId(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(membresiaService.findByClientId(clienteId));
    }

    @GetMapping("/tipo/{tipoMembresia}")
    public ResponseEntity<List<MembresiaDTO>> getByType(@PathVariable String tipoMembresia) {
        return ResponseEntity.ok(membresiaService.findByType(tipoMembresia));
    }

    @GetMapping("/estado/{estadoMembresia}")
    public ResponseEntity<List<MembresiaDTO>> getByStatus(@PathVariable String estadoMembresia) {
        return ResponseEntity.ok(membresiaService.findByStatus(estadoMembresia));
    }

    @GetMapping("/fecha-inicio")
    public ResponseEntity<List<MembresiaDTO>> getByStartDateBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return ResponseEntity.ok(membresiaService.findByStartDateBetween(start, end));
    }

    @GetMapping("/fecha-fin")
    public ResponseEntity<List<MembresiaDTO>> getByEndDateBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return ResponseEntity.ok(membresiaService.findByEndDateBetween(start, end));
    }

    @GetMapping("/cliente/{clienteId}/activa")
    public ResponseEntity<List<MembresiaDTO>> getActiveByClientId(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(membresiaService.findActiveByClientId(clienteId));
    }

    @GetMapping("/activa")
    public ResponseEntity<List<MembresiaDTO>> getAllActive() {
        return ResponseEntity.ok(membresiaService.findAllActive());
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<MembresiaDTO> updateStatus(@PathVariable Integer id, @RequestParam String estadoMembresia) {
        return ResponseEntity.ok(membresiaService.updateStatus(id, estadoMembresia));
    }

}
