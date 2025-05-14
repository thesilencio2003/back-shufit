package com.shufitapp.shufit.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.shufitapp.shufit.dto.NotificacionDTO;
import com.shufitapp.shufit.service.NotificacionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {

       private final NotificacionService notificacionService;

    @GetMapping
    public ResponseEntity<List<NotificacionDTO>> getAll() {
        return ResponseEntity.ok(notificacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionDTO> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(notificacionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<NotificacionDTO> create(@RequestBody NotificacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificacionService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacionDTO> update(@PathVariable Integer id, @RequestBody NotificacionDTO dto) {
        return ResponseEntity.ok(notificacionService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        notificacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{userId}")
    public ResponseEntity<List<NotificacionDTO>> getByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(notificacionService.findByUserId(userId));
    }

    @GetMapping("/tipo/{type}")
    public ResponseEntity<List<NotificacionDTO>> getByType(@PathVariable String type) {
        return ResponseEntity.ok(notificacionService.findByType(type));
    }

    @GetMapping("/usuario/{userId}/unread")
    public ResponseEntity<List<NotificacionDTO>> getUnreadByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(notificacionService.findUnreadByUserId(userId));
    }

    @PatchMapping("/{id}/mark-as-read")
    public ResponseEntity<NotificacionDTO> markAsRead(@PathVariable Integer id) {
        return ResponseEntity.ok(notificacionService.markAsRead(id));
    }

}
