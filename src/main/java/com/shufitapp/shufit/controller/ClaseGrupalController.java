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

import com.shufitapp.shufit.dto.ClaseGrupalDTO;
import com.shufitapp.shufit.service.ClaseGrupalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clases-grupales")
@RequiredArgsConstructor
public class ClaseGrupalController {

     private final ClaseGrupalService claseGrupalService;

    @GetMapping
    public ResponseEntity<List<ClaseGrupalDTO>> getAll() {
        return ResponseEntity.ok(claseGrupalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaseGrupalDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(claseGrupalService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClaseGrupalDTO> create(@RequestBody ClaseGrupalDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(claseGrupalService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaseGrupalDTO> update(@PathVariable Integer id, @RequestBody ClaseGrupalDTO dto) {
        return ResponseEntity.ok(claseGrupalService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        claseGrupalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
