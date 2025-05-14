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

import com.shufitapp.shufit.dto.EvaluacionInicialDTO;
import com.shufitapp.shufit.service.EvaluacionInicialService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/evaluaciones-iniciales")
@RequiredArgsConstructor
public class EvaluacionInicialController {

      private final EvaluacionInicialService evaluacionInicialService;

    @GetMapping
    public ResponseEntity<List<EvaluacionInicialDTO>> getAll() {
        return ResponseEntity.ok(evaluacionInicialService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionInicialDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(evaluacionInicialService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EvaluacionInicialDTO> create(@RequestBody EvaluacionInicialDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(evaluacionInicialService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluacionInicialDTO> update(@PathVariable Integer id, @RequestBody EvaluacionInicialDTO dto) {
        return ResponseEntity.ok(evaluacionInicialService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        evaluacionInicialService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<EvaluacionInicialDTO> getByClienteId(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(evaluacionInicialService.findByClienteId(clienteId));
    }

}
