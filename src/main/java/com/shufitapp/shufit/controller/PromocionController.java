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

import com.shufitapp.shufit.dto.PromocionDTO;
import com.shufitapp.shufit.service.PromocionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/promociones")
@RequiredArgsConstructor
public class PromocionController {

      private final PromocionService promocionService;

    @GetMapping
    public ResponseEntity<List<PromocionDTO>> getAll() {
        return ResponseEntity.ok(promocionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromocionDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(promocionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PromocionDTO> create(@RequestBody PromocionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(promocionService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PromocionDTO> update(@PathVariable Integer id, @RequestBody PromocionDTO dto) {
        return ResponseEntity.ok(promocionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        promocionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<PromocionDTO> getByCodigo(@PathVariable String codigo) {
        PromocionDTO promocionDTO = promocionService.findByCodigo(codigo);
        return promocionDTO != null ? ResponseEntity.ok(promocionDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping("/activas")
    public ResponseEntity<List<PromocionDTO>> getActivas() {
        return ResponseEntity.ok(promocionService.findActivas());
    }

    @GetMapping("/aplica-a/{aplicaA}")
    public ResponseEntity<List<PromocionDTO>> getByAplicaA(@PathVariable String aplicaA) {
        return ResponseEntity.ok(promocionService.findByAplicaA(aplicaA));
    }

}
