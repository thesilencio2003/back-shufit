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

import com.shufitapp.shufit.dto.RecepcionistaDTO;
import com.shufitapp.shufit.service.RecepcionistaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/recepcionistas")
@RequiredArgsConstructor
public class RecepcionistaController {

    private final RecepcionistaService recepcionistaService;

    @GetMapping
    public ResponseEntity<List<RecepcionistaDTO>> getAll() {
        return ResponseEntity.ok(recepcionistaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecepcionistaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(recepcionistaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RecepcionistaDTO> create(@RequestBody RecepcionistaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recepcionistaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecepcionistaDTO> update(@PathVariable Integer id, @RequestBody RecepcionistaDTO dto) {
        return ResponseEntity.ok(recepcionistaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        recepcionistaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/persona/{personaId}")
    public ResponseEntity<RecepcionistaDTO> getByPersonaId(@PathVariable Integer personaId) {
        return ResponseEntity.ok(recepcionistaService.findByPersonaId(personaId));
    }

}
