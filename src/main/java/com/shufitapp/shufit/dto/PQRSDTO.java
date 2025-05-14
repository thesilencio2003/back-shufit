package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PQRSDTO {

    private Integer idPqrs;
    private Integer clienteId;
    private String tipoPqrs;
    private String asunto;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private String estadoPqrs;
    private String respuesta;
    private LocalDateTime fechaRespuesta;

}
