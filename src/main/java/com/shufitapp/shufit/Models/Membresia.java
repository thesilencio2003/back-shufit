package com.shufitapp.shufit.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "membresia")
@Data
public class Membresia {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMembresia;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_MEMBRESIA_CLIENTE"))
    private Cliente cliente;

    @Column(name = "tipo_membresia", nullable = false, length = 100)
    private String tipoMembresia;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private Double precio;

    @Column(name = "estado_membresia", nullable = false, length = 50, columnDefinition = "VARCHAR(50) DEFAULT 'Activa'")
    private String estadoMembresia;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

}
