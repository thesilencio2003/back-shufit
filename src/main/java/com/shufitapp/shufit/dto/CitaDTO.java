package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CitaDTO {

    private Integer idCita;
    private Integer clienteId;
    private Integer entrenadorId;
    private Integer nutricionistaId;
    private LocalDateTime fechaHora;
    private String tipoCita;
    private String comentarios;
    private String estadoCita;

}
