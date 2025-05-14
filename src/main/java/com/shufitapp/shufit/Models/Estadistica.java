package com.shufitapp.shufit.Models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "estadisticas")
@Data
public class Estadistica {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadistica;

    @CreationTimestamp
    @Column(name = "fecha_calculo", updatable = false)
    private LocalDateTime fechaCalculo;

    @Column(name = "total_clientes_activos")
    private Integer totalClientesActivos;

    @Column(name = "promedio_citas_semana")
    private Double promedioCitasSemana;

    @Column(name = "ingresos_mes_actual")
    private Double ingresosMesActual;

    @Column(name = "nuevos_clientes_mes_actual")
    private Integer nuevosClientesMesActual;

    @Column(name = "membresias_activas")
    private Integer membresiasActivas;
}
