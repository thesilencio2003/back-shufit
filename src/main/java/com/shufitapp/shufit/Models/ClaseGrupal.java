package com.shufitapp.shufit.Models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "clasegrupal")
@Data
public class ClaseGrupal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClase;

    @Column(name = "nombre_clase", nullable = false, length = 100)
    private String nombreClase;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "horario_inicio", nullable = false)
    private LocalDateTime horarioInicio;

    @Column(name = "horario_fin", nullable = false)
    private LocalDateTime horarioFin;

    @Column(name = "cupo_maximo")
    private Integer cupoMaximo;

    @Column(name = "ubicacion", length = 255)
    private String ubicacion;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion; 

}
