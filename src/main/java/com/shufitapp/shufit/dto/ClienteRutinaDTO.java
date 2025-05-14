package com.shufitapp.shufit.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ClienteRutinaDTO {

    private Integer clienteId;
    private Integer rutinaId;
    private LocalDateTime fechaAsignacion;
    private LocalDate posibleFechaFinalizacion;
    private String comentarios;

}
