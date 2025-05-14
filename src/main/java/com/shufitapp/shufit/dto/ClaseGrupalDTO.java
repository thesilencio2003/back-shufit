package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ClaseGrupalDTO {

    private Integer idClase;
    private String nombreClase;
    private String descripcion;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFin;
    private Integer cupoMaximo;
    private String ubicacion;

}
