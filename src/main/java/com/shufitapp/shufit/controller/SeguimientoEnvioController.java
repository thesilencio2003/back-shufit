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

import com.shufitapp.shufit.dto.SeguimientoEnvioDTO;
import com.shufitapp.shufit.service.SeguimientoEnvioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/seguimiento-envios")
@RequiredArgsConstructor
public class SeguimientoEnvioController {

        private final SeguimientoEnvioService seguimientoEnvioService;

    @GetMapping
    public ResponseEntity<List<SeguimientoEnvioDTO>> getAll() {
        return ResponseEntity.ok(seguimientoEnvioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeguimientoEnvioDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(seguimientoEnvioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SeguimientoEnvioDTO> create(@RequestBody SeguimientoEnvioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(seguimientoEnvioService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeguimientoEnvioDTO> update(@PathVariable Integer id, @RequestBody SeguimientoEnvioDTO dto) {
        return ResponseEntity.ok(seguimientoEnvioService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        seguimientoEnvioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/factura/{facturaId}")
    public ResponseEntity<SeguimientoEnvioDTO> getByFacturaId(@PathVariable Integer facturaId) {
        SeguimientoEnvioDTO seguimientoEnvioDTO = seguimientoEnvioService.findByFacturaId(facturaId);
        return seguimientoEnvioDTO != null ? ResponseEntity.ok(seguimientoEnvioDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping("/guia/{numeroGuia}")
    public ResponseEntity<SeguimientoEnvioDTO> getByNumeroGuia(@PathVariable String numeroGuia) {
        SeguimientoEnvioDTO seguimientoEnvioDTO = seguimientoEnvioService.findByNumeroGuia(numeroGuia);
        return seguimientoEnvioDTO != null ? ResponseEntity.ok(seguimientoEnvioDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping("/estado/{estadoEnvio}")
    public ResponseEntity<List<SeguimientoEnvioDTO>> getByEstadoEnvio(@PathVariable String estadoEnvio) {
        return ResponseEntity.ok(seguimientoEnvioService.findByEstadoEnvio(estadoEnvio));
    }
}
