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
@Table(name = "auditoria")
@Data
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuditoria;

    @CreationTimestamp
    @Column(name = "fecha_hora_evento", updatable = false)
    private LocalDateTime fechaHoraEvento;

    @Column(name = "tipo_evento", nullable = false, length = 100)
    private String tipoEvento;

    @Column(name = "usuario", length = 255)
    private String usuario;

    @Column(name = "entidad_afectada", length = 100)
    private String entidadAfectada;

    @Column(name = "id_entidad_afectada")
    private Integer idEntidadAfectada;

    @Column(name = "detalles_cambio", columnDefinition = "TEXT")
    private String detallesCambio;

}
