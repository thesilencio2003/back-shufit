package com.shufitapp.shufit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.shufitapp.shufit.dto.PersonaDTO;
import com.shufitapp.shufit.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

     @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> getAll() {
        return ResponseEntity.ok(personaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(personaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PersonaDTO> create(@RequestBody PersonaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDTO> update(@PathVariable Integer id, @RequestBody PersonaDTO dto) {
        return ResponseEntity.ok(personaService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        personaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
