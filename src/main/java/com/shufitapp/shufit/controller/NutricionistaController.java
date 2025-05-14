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

import com.shufitapp.shufit.dto.NutricionistaDTO;
import com.shufitapp.shufit.service.NutricionistaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/nutricionistas")
@RequiredArgsConstructor
public class NutricionistaController {

        private final NutricionistaService nutricionistaService;

    @GetMapping
    public ResponseEntity<List<NutricionistaDTO>> getAll() {
        return ResponseEntity.ok(nutricionistaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutricionistaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(nutricionistaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<NutricionistaDTO> create(@RequestBody NutricionistaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(nutricionistaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NutricionistaDTO> update(@PathVariable Integer id, @RequestBody NutricionistaDTO dto) {
        return ResponseEntity.ok(nutricionistaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        nutricionistaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/persona/{personaId}")
    public ResponseEntity<NutricionistaDTO> getByPersonaId(@PathVariable Integer personaId) {
        return ResponseEntity.ok(nutricionistaService.findByPersonaId(personaId));
    }
}
