package com.shufitapp.shufit.Models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "seguimiento_envio")
@Data
public class SeguimientoEnvio {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seguimiento")
    private Integer idSeguimiento;

    @OneToOne
    @JoinColumn(name = "id_factura", unique = true, nullable = false, foreignKey = @ForeignKey(name = "FK_SEGUIMIENTO_FACTURA"))
    private Factura factura;

    @Column(name = "compania_envio", length = 100)
    private String companiaEnvio;

    @Column(name = "numero_guia", length = 100)
    private String numeroGuia;

    @Column(name = "fecha_envio")
    private LocalDateTime fechaEnvio;

    @Column(name = "estado_envio", length = 50)
    private String estadoEnvio;

    @Column(name = "direccion_entrega", length = 255)
    private String direccionEntrega;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;
}
