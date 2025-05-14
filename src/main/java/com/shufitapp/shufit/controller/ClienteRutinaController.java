package com.shufitapp.shufit.controller;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shufitapp.shufit.dto.ClienteRutinaDTO;
import com.shufitapp.shufit.service.ClienteRutinaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/clientes-rutinas")
@RequiredArgsConstructor
public class ClienteRutinaController {

    private final ClienteRutinaService clienteRutinaService;

    @GetMapping
    public ResponseEntity<List<ClienteRutinaDTO>> getAll() {
        return ResponseEntity.ok(clienteRutinaService.findAll());
    }

    @GetMapping("/{clienteId}/{rutinaId}")
    public ResponseEntity<ClienteRutinaDTO> getById(@PathVariable Integer clienteId, @PathVariable Integer rutinaId) {
        return ResponseEntity.ok(clienteRutinaService.findById(clienteId, rutinaId));
    }

    @PostMapping
    public ResponseEntity<ClienteRutinaDTO> create(@RequestBody ClienteRutinaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRutinaService.save(dto));
    }

    @PutMapping("/{clienteId}/{rutinaId}")
    public ResponseEntity<ClienteRutinaDTO> update(@PathVariable Integer clienteId, @PathVariable Integer rutinaId,
            @RequestBody ClienteRutinaDTO dto) {
        return ResponseEntity.ok(clienteRutinaService.update(clienteId, rutinaId, dto));
    }

    @DeleteMapping("/{clienteId}/{rutinaId}")
    public ResponseEntity<Void> delete(@PathVariable Integer clienteId, @PathVariable Integer rutinaId) {
        clienteRutinaService.deleteById(clienteId, rutinaId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<List<ClienteRutinaDTO>> getByClienteId(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(clienteRutinaService.findByClienteId(clienteId));
    }

    @GetMapping("/rutinas/{rutinaId}")
    public ResponseEntity<List<ClienteRutinaDTO>> getByRutinaId(@PathVariable Integer rutinaId) {
        return ResponseEntity.ok(clienteRutinaService.findByRutinaId(rutinaId));
    }

    @PostMapping("/clientes/{clienteId}/rutinas/{rutinaId}")
    public ResponseEntity<ClienteRutinaDTO> assignRoutineToClient(
            @PathVariable Integer clienteId,
            @PathVariable Integer rutinaId,
            @RequestParam(required = false) LocalDate posibleFechaFinalizacion,
            @RequestParam(required = false) String comentarios) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteRutinaService.assignRoutineToClient(clienteId, rutinaId, posibleFechaFinalizacion,
                        comentarios));
    }

    @DeleteMapping("/clientes/{clienteId}/rutinas/{rutinaId}")
    public ResponseEntity<Void> unassignRoutineFromClient(
            @PathVariable Integer clienteId,
            @PathVariable Integer rutinaId) {
        clienteRutinaService.unassignRoutineFromClient(clienteId, rutinaId);
        return ResponseEntity.noContent().build();
    }

}
