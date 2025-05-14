package com.shufitapp.shufit.Models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "notificacion")
@Data
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNotificacion;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "tipo_notificacion", nullable = false, length = 100)
    private String tipoNotificacion;

    @Column(name = "mensaje", nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @CreationTimestamp
    @Column(name = "fecha_envio", updatable = false)
    private LocalDateTime fechaEnvio;

    @Column(name = "leida", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean leida;

    @Column(name = "tipo_entidad_relacionada", length = 100)
    private String tipoEntidadRelacionada;

    @Column(name = "id_entidad_relacionada")
    private Integer idEntidadRelacionada;
}
