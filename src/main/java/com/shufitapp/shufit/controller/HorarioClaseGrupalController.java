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

import com.shufitapp.shufit.dto.HorarioClaseGrupalDTO;
import com.shufitapp.shufit.service.HorarioClaseGrupalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/horarios-clase-grupal")
@RequiredArgsConstructor
public class HorarioClaseGrupalController {

  private final HorarioClaseGrupalService horarioClaseGrupalService;

    @GetMapping
    public ResponseEntity<List<HorarioClaseGrupalDTO>> getAll() {
        return ResponseEntity.ok(horarioClaseGrupalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioClaseGrupalDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(horarioClaseGrupalService.findById(id));
    }

    @PostMapping
    public ResponseEntity<HorarioClaseGrupalDTO> create(@RequestBody HorarioClaseGrupalDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioClaseGrupalService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorarioClaseGrupalDTO> update(@PathVariable Integer id, @RequestBody HorarioClaseGrupalDTO dto) {
        return ResponseEntity.ok(horarioClaseGrupalService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        horarioClaseGrupalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/clases/{claseId}")
    public ResponseEntity<List<HorarioClaseGrupalDTO>> getByClaseId(@PathVariable Integer claseId) {
        return ResponseEntity.ok(horarioClaseGrupalService.findByClaseId(claseId));
    }

}
