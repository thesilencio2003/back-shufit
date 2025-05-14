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

import com.shufitapp.shufit.dto.RutinaDTO;
import com.shufitapp.shufit.service.RutinaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rutinas")
@RequiredArgsConstructor

public class RutinaController {

  private final RutinaService rutinaService;

    @GetMapping
    public ResponseEntity<List<RutinaDTO>> getAll() {
        return ResponseEntity.ok(rutinaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RutinaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(rutinaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<RutinaDTO> create(@RequestBody RutinaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rutinaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RutinaDTO> update(@PathVariable Integer id, @RequestBody RutinaDTO dto) {
        return ResponseEntity.ok(rutinaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        rutinaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }  

}
