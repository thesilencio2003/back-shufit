package com.shufitapp.shufit.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shufitapp.shufit.dto.AuditoriaDTO;
import com.shufitapp.shufit.service.AuditoriaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auditoria")
@RequiredArgsConstructor
public class AuditoriaController {
    private final AuditoriaService auditoriaService;

    @GetMapping
    public ResponseEntity<List<AuditoriaDTO>> getAll() {
        return ResponseEntity.ok(auditoriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditoriaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(auditoriaService.findById(id));
    }

    @GetMapping("/usuario/{usuario}")
    public ResponseEntity<List<AuditoriaDTO>> getByUsuario(@PathVariable String usuario) {
        return ResponseEntity.ok(auditoriaService.findByUsuario(usuario));
    }

    @GetMapping("/tipo-evento/{tipoEvento}")
    public ResponseEntity<List<AuditoriaDTO>> getByTipoEvento(@PathVariable String tipoEvento) {
        return ResponseEntity.ok(auditoriaService.findByTipoEvento(tipoEvento));
    }

    @GetMapping("/entidad/{entidadAfectada}")
    public ResponseEntity<List<AuditoriaDTO>> getByEntidadAfectada(@PathVariable String entidadAfectada) {
        return ResponseEntity.ok(auditoriaService.findByEntidadAfectada(entidadAfectada));
    }

    @GetMapping("/fecha-hora")
    public ResponseEntity<List<AuditoriaDTO>> getByFechaHoraEventoBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(auditoriaService.findByFechaHoraEventoBetween(start, end));
    }

    @GetMapping("/entidad/{entidadAfectada}/id/{idEntidadAfectada}")
    public ResponseEntity<List<AuditoriaDTO>> getByEntidadAfectadaAndIdEntidadAfectada(
            @PathVariable String entidadAfectada, @PathVariable Integer idEntidadAfectada) {
        return ResponseEntity.ok(auditoriaService.findByEntidadAfectadaAndIdEntidadAfectada(entidadAfectada, idEntidadAfectada));
    }
}
