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

import com.shufitapp.shufit.dto.PlanEntrenamientoDTO;
import com.shufitapp.shufit.service.PlanEntrenamientoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/planes-entrenamiento")
@RequiredArgsConstructor
public class PlanEntrenamientoController {

    private final PlanEntrenamientoService planEntrenamientoService;

    @GetMapping
    public ResponseEntity<List<PlanEntrenamientoDTO>> getAll() {
        return ResponseEntity.ok(planEntrenamientoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanEntrenamientoDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(planEntrenamientoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PlanEntrenamientoDTO> create(@RequestBody PlanEntrenamientoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(planEntrenamientoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanEntrenamientoDTO> update(@PathVariable Integer id, @RequestBody PlanEntrenamientoDTO dto) {
        return ResponseEntity.ok(planEntrenamientoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        planEntrenamientoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
