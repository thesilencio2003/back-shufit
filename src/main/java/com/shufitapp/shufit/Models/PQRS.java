package com.shufitapp.shufit.Models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pqrs")
@Data
public class PQRS {

      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPqrs;

    @ManyToOne
    @JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "FK_PQRS_CLIENTE"))
    private Cliente cliente;

    @Column(name = "tipo_pqrs", nullable = false, length = 50)
    private String tipoPqrs;

    @Column(name = "asunto", nullable = false, length = 255)
    private String asunto;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "estado_pqrs", nullable = false, length = 50, columnDefinition = "VARCHAR(50) DEFAULT 'Recibido'")
    private String estadoPqrs;

    @Column(name = "respuesta", columnDefinition = "TEXT")
    private String respuesta;

    @Column(name = "fecha_respuesta")
    private LocalDateTime fechaRespuesta;

}
