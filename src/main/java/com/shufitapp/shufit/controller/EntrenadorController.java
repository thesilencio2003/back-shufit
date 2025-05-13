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

import com.shufitapp.shufit.dto.EntrenadorDTO;
import com.shufitapp.shufit.service.EntrenadorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/entrenadores")
@RequiredArgsConstructor
public class EntrenadorController {

        private final EntrenadorService entrenadorService;

    @GetMapping
    public ResponseEntity<List<EntrenadorDTO>> getAll() {
        return ResponseEntity.ok(entrenadorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntrenadorDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(entrenadorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EntrenadorDTO> create(@RequestBody EntrenadorDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entrenadorService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntrenadorDTO> update(@PathVariable Integer id, @RequestBody EntrenadorDTO dto) {
        return ResponseEntity.ok(entrenadorService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        entrenadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/persona/{personaId}")
    public ResponseEntity<EntrenadorDTO> getByPersonaId(@PathVariable Integer personaId) {
        return ResponseEntity.ok(entrenadorService.findByPersonaId(personaId));
    }

}
