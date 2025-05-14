package com.shufitapp.shufit.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "objetivo")
@Data
public class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idObjetivo;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_OBJETIVO_CLIENTE"))
    private Cliente cliente;

    @Column(name = "tipo_objetivo", nullable = false, length = 100)
    private String tipoObjetivo;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "meta", nullable = false)
    private Double meta;

    @Column(name = "unidad_meta", nullable = false, length = 50)
    private String unidadMeta;

    @Column(name = "progreso", nullable = false, columnDefinition = "DOUBLE DEFAULT 0.0")
    private Double progreso;

    @Column(name = "fecha_progreso_actualizacion")
    private LocalDateTime fechaProgresoActualizacion;

    @Column(name = "estado_objetivo", nullable = false, length = 50, columnDefinition = "VARCHAR(50) DEFAULT 'En progreso'")
    private String estadoObjetivo;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

}
