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

import com.shufitapp.shufit.dto.ContactoDTO;
import com.shufitapp.shufit.service.ContactoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/contactos")
@RequiredArgsConstructor
public class ContactoController {

        private final ContactoService contactoService;

    @GetMapping
    public ResponseEntity<List<ContactoDTO>> getAll() {
        return ResponseEntity.ok(contactoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(contactoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ContactoDTO> create(@RequestBody ContactoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactoService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactoDTO> update(@PathVariable Integer id, @RequestBody ContactoDTO dto) {
        return ResponseEntity.ok(contactoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        contactoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ContactoDTO>> getByNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(contactoService.findByNombre(nombre));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<ContactoDTO>> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(contactoService.findByEmail(email));
    }

    @GetMapping("/asunto/{asunto}")
    public ResponseEntity<List<ContactoDTO>> getByAsunto(@PathVariable String asunto) {
        return ResponseEntity.ok(contactoService.findByAsunto(asunto));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<ContactoDTO>> getByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(contactoService.findByEstado(estado));
    }

    @GetMapping("/fecha-contacto")
    public ResponseEntity<List<ContactoDTO>> getByFechaContactoBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(contactoService.findByFechaContactoBetween(start, end));
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<ContactoDTO> updateEstado(@PathVariable Integer id, @RequestParam String estado) {
        return ResponseEntity.ok(contactoService.updateEstado(id, estado));
    }

}
