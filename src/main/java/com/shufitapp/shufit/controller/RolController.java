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

import com.shufitapp.shufit.dto.RolDTO;
import com.shufitapp.shufit.service.RolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolController {

     private final RolService rolService;

    @GetMapping
    public ResponseEntity<List<RolDTO>> getAll() {
        return ResponseEntity.ok(rolService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(rolService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RolDTO> create(@RequestBody RolDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rolService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> update(@PathVariable Integer id, @RequestBody RolDTO dto) {
        return ResponseEntity.ok(rolService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
