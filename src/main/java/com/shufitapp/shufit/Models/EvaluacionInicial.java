package com.shufitapp.shufit.Models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "evaluacion_inicial")
@Data
public class EvaluacionInicial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvaluacionInicial;

    @OneToOne
    @JoinColumn(name = "id_cliente", unique = true, nullable = false, foreignKey = @ForeignKey(name = "FK_EVALUACION_INICIAL_CLIENTE"))
    private Cliente cliente;

    @CreationTimestamp
    @Column(name = "fecha_evaluacion", updatable = false)
    private LocalDateTime fechaEvaluacion;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "altura")
    private Double altura;

    @Column(name = "imc")
    private Double imc;

    @Column(name = "porcentaje_grasa")
    private Double porcentajeGrasa;

    @Column(name = "medidas_antropometricas", columnDefinition = "TEXT")
    private String medidasAntropometricas;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;
}
