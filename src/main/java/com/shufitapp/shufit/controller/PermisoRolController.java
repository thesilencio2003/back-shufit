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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shufitapp.shufit.dto.PermisoRolDTO;
import com.shufitapp.shufit.service.PermisoRolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/permisos-rol")
@RequiredArgsConstructor
public class PermisoRolController {

     private final PermisoRolService permisoRolService;

    @GetMapping
    public ResponseEntity<List<PermisoRolDTO>> getAll() {
        return ResponseEntity.ok(permisoRolService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermisoRolDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(permisoRolService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PermisoRolDTO> create(@RequestBody PermisoRolDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(permisoRolService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PermisoRolDTO> update(@PathVariable Integer id, @RequestBody PermisoRolDTO dto) {
        return ResponseEntity.ok(permisoRolService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        permisoRolService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/roles/{rolId}")
    public ResponseEntity<List<PermisoRolDTO>> getByRolId(@PathVariable Integer rolId) {
        return ResponseEntity.ok(permisoRolService.findByRolId(rolId));
    }

    @PostMapping("/roles/{rolId}")
    public ResponseEntity<PermisoRolDTO> addPermissionToRole(@PathVariable Integer rolId, @RequestParam String permissionName, @RequestParam(required = false) String description) {
        return ResponseEntity.status(HttpStatus.CREATED).body(permisoRolService.addPermissionToRole(rolId, permissionName, description));
    }

    @DeleteMapping("/roles/{rolId}")
    public ResponseEntity<Void> removePermissionFromRole(@PathVariable Integer rolId, @RequestParam String permissionName) {
        permisoRolService.removePermissionFromRole(rolId, permissionName);
        return ResponseEntity.noContent().build();
    }

}
