package com.shufitapp.shufit.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shufitapp.shufit.dto.PQRSDTO;
import com.shufitapp.shufit.service.PQRSService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pqrs")
@RequiredArgsConstructor
public class PQRSController {

     private final PQRSService pqrsService;

    @GetMapping
    public ResponseEntity<List<PQRSDTO>> getAll() {
        return ResponseEntity.ok(pqrsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PQRSDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(pqrsService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PQRSDTO> create(@RequestBody PQRSDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pqrsService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PQRSDTO> update(@PathVariable Integer id, @RequestBody PQRSDTO dto) {
        return ResponseEntity.ok(pqrsService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pqrsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PQRSDTO>> getByClientId(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(pqrsService.findByClientId(clienteId));
    }

    @GetMapping("/tipo/{tipoPqrs}")
    public ResponseEntity<List<PQRSDTO>> getByType(@PathVariable String tipoPqrs) {
        return ResponseEntity.ok(pqrsService.findByType(tipoPqrs));
    }

    @GetMapping("/estado/{estadoPqrs}")
    public ResponseEntity<List<PQRSDTO>> getByStatus(@PathVariable String estadoPqrs) {
        return ResponseEntity.ok(pqrsService.findByStatus(estadoPqrs));
    }

    @GetMapping("/fecha-creacion")
    public ResponseEntity<List<PQRSDTO>> getByCreationDateBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(pqrsService.findByCreationDateBetween(start, end));
    }

    @PatchMapping("/{id}/reply")
    public ResponseEntity<PQRSDTO> reply(@PathVariable Integer id, @RequestParam String respuesta) {
        return ResponseEntity.ok(pqrsService.reply(id, respuesta));
    }

}
