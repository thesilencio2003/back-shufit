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

import com.shufitapp.shufit.dto.FacturaDTO;
import com.shufitapp.shufit.service.FacturaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/facturas")
@RequiredArgsConstructor
public class FacturaController {

      private final FacturaService facturaService;

    @GetMapping
    public ResponseEntity<List<FacturaDTO>> getAll() {
        return ResponseEntity.ok(facturaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(facturaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FacturaDTO> create(@RequestBody FacturaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaDTO> update(@PathVariable Integer id, @RequestBody FacturaDTO dto) {
        return ResponseEntity.ok(facturaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        facturaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<FacturaDTO>> getByClienteId(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(facturaService.findByClienteId(clienteId));
    }

    @GetMapping("/cabecera/{idCabeceraFactura}")
    public ResponseEntity<FacturaDTO> getByCabeceraFacturaId(@PathVariable Integer idCabeceraFactura) {
        FacturaDTO facturaDTO = facturaService.findByCabeceraFacturaId(idCabeceraFactura);
        return facturaDTO != null ? ResponseEntity.ok(facturaDTO) : ResponseEntity.notFound().build();
    }

}
