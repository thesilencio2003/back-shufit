package com.shufitapp.shufit.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ObjetivoDTO {

    private Integer idObjetivo;
    private Integer clienteId;
    private String tipoObjetivo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double meta;
    private String unidadMeta;
    private Double progreso;
    private LocalDateTime fechaProgresoActualizacion;
    private String estadoObjetivo;
}
