package com.shufitapp.shufit.Models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "historial_medico")
@Data
public class HistorialMedico {

      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistorialMedico;

    @OneToOne
    @JoinColumn(name = "id_cliente", unique = true, nullable = false, foreignKey = @ForeignKey(name = "FK_HISTORIAL_MEDICO_CLIENTE"))
    private Cliente cliente;

    @CreationTimestamp
    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "antecedentes_medicos", columnDefinition = "TEXT")
    private String antecedentesMedicos;

    @Column(name = "alergias", columnDefinition = "TEXT")
    private String alergias;

    @Column(name = "lesiones_previas", columnDefinition = "TEXT")
    private String lesionesPrevias;

    @Column(name = "medicamentos_actuales", columnDefinition = "TEXT")
    private String medicamentosActuales;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

}
