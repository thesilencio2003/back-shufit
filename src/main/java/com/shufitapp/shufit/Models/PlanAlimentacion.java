package com.shufitapp.shufit.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "plan_alimentacion")
@Data
public class PlanAlimentacion {

      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
    private Integer idPlan;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_PLAN_CLIENTE"))
    private Cliente cliente;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "objetivo", length = 100)
    private String objetivo;

    @Column(name = "calorias_diarias")
    private Integer caloriasDiarias;

    @Column(name = "proteinas", precision = 5, scale = 2)
    private Double proteinas;

    @Column(name = "carbohidratos", precision = 5, scale = 2)
    private Double carbohidratos;

    @Column(name = "grasas", precision = 5, scale = 2)
    private Double grasas;

    @Column(name = "recomendaciones", columnDefinition = "TEXT")
    private String recomendaciones;

    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

}
