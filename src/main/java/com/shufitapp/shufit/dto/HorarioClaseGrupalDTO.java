package com.shufitapp.shufit.dto;

import java.time.LocalTime;

import lombok.Data;

@Data
public class HorarioClaseGrupalDTO {

    private Integer idHorarioClase;
    private Integer claseId; 
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String ubicacion;

}
