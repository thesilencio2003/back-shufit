package com.shufitapp.shufit.Models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cita")
@Data
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_CITA_CLIENTE"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_entrenador", foreignKey = @ForeignKey(name = "FK_CITA_ENTRENADOR"))
    private Entrenador entrenador;

    @ManyToOne
    @JoinColumn(name = "id_nutricionista", foreignKey = @ForeignKey(name = "FK_CITA_NUTRICIONISTA"))
    private Nutricionista nutricionista;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(name = "tipo_cita", nullable = false, length = 50)
    private String tipoCita;

    @Column(name = "comentarios", columnDefinition = "TEXT")
    private String comentarios;

    @Column(name = "estado_cita", nullable = false, length = 50)
    private String estadoCita;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;
}
