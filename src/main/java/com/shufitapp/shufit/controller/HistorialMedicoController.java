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

import com.shufitapp.shufit.dto.HistorialMedicoDTO;
import com.shufitapp.shufit.service.HistorialMedicoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/historiales-medicos")
@RequiredArgsConstructor
public class HistorialMedicoController {

      private final HistorialMedicoService historialMedicoService;

    @GetMapping
    public ResponseEntity<List<HistorialMedicoDTO>> getAll() {
        return ResponseEntity.ok(historialMedicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialMedicoDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(historialMedicoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<HistorialMedicoDTO> create(@RequestBody HistorialMedicoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(historialMedicoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialMedicoDTO> update(@PathVariable Integer id, @RequestBody HistorialMedicoDTO dto) {
        return ResponseEntity.ok(historialMedicoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        historialMedicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<HistorialMedicoDTO> getByClienteId(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(historialMedicoService.findByClienteId(clienteId));
    }

}
