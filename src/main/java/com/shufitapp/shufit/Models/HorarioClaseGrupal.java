package com.shufitapp.shufit.Models;

import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "horarioclasegrupal")
@Data
public class HorarioClaseGrupal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHorarioClase;

    @ManyToOne
    @JoinColumn(name = "id_clase", nullable = false, foreignKey = @ForeignKey(name = "FK_HORARIOCLASEGRUPAL_CLASEGRUPAL"))
    private ClaseGrupal claseGrupal;

    @Column(name = "dia_semana", nullable = false, length = 20)
    private String diaSemana;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @Column(name = "ubicacion", length = 255)
    private String ubicacion;

}
