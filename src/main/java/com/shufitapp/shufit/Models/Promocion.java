package com.shufitapp.shufit.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "promocion")
@Data
public class Promocion {

      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_promocion")
    private Integer idPromocion;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "tipo_descuento", nullable = false, length = 50)
    private String tipoDescuento; 

    @Column(name = "valor_descuento", nullable = false, precision = 10, scale = 2)
    private Double valorDescuento;

    @Column(name = "aplica_a", nullable = false, length = 50)
    private String aplicaA; 

    @Column(name = "codigo_promocion", unique = true, length = 50)
    private String codigoPromocion;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;
}
