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

import com.shufitapp.shufit.dto.CabeceraFacturaDTO;
import com.shufitapp.shufit.service.CabeceraFacturaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cabeceras-factura")
@RequiredArgsConstructor
public class CabeceraFacturaController {

 private final CabeceraFacturaService cabeceraFacturaService;

    @GetMapping
    public ResponseEntity<List<CabeceraFacturaDTO>> getAll() {
        return ResponseEntity.ok(cabeceraFacturaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CabeceraFacturaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(cabeceraFacturaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CabeceraFacturaDTO> create(@RequestBody CabeceraFacturaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cabeceraFacturaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CabeceraFacturaDTO> update(@PathVariable Integer id, @RequestBody CabeceraFacturaDTO dto) {
        return ResponseEntity.ok(cabeceraFacturaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        cabeceraFacturaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }   

}
