package com.shufitapp.shufit.Models
;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.shufitapp.shufit.Models.Cliente;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "evaluacion_rendimiento")
@Data
public class EvaluacionRendimiento {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvaluacionRendimiento;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_EVALUACION_RENDIMIENTO_CLIENTE"))
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

    @Column(name = "pruebas_rendimiento", columnDefinition = "TEXT")
    private String pruebasRendimiento;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;
}
