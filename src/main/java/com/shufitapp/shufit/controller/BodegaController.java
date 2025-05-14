package com.shufitapp.shufit.controller;

import com.shufitapp.shufit.dto.BodegaDTO;
import com.shufitapp.shufit.service.BodegaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bodegas")
@RequiredArgsConstructor
public class BodegaController {

     private final BodegaService bodegaService;

    @GetMapping
    public ResponseEntity<List<BodegaDTO>> getAll() {
        return ResponseEntity.ok(bodegaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BodegaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(bodegaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<BodegaDTO> create(@RequestBody BodegaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bodegaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodegaDTO> update(@PathVariable Integer id, @RequestBody BodegaDTO dto) {
        return ResponseEntity.ok(bodegaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bodegaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<BodegaDTO>> getByNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(bodegaService.findByNombre(nombre));
    }

}
