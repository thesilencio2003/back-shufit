package com.shufitapp.shufit.Models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cancelacion")
@Data
public class Cancelacion {

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cancelacion")
    private Integer idCancelacion;

    @ManyToOne
    @JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "FK_CANCELACION_CLIENTE"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_factura", foreignKey = @ForeignKey(name = "FK_CANCELACION_FACTURA"))
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "id_membresia", foreignKey = @ForeignKey(name = "FK_CANCELACION_MEMBRESIA"))
    private Membresia membresia;

    @CreationTimestamp
    @Column(name = "fecha_solicitud", updatable = false)
    private LocalDateTime fechaSolicitud;

    @Column(name = "motivo", columnDefinition = "TEXT")
    private String motivo;

    @Column(name = "estado_cancelacion", length = 50)
    private String estadoCancelacion; 

    @Column(name = "fecha_resolucion")
    private LocalDateTime fechaResolucion;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "tipo_cancelacion", length = 50)
    private String tipoCancelacion; 

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

}
