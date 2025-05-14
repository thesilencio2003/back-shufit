package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CancelacionDTO {
 private Integer idCancelacion;
    private Integer clienteId;
    private Integer facturaId;
    private Integer membresiaId;
    private LocalDateTime fechaSolicitud;
    private String motivo;
    private String estadoCancelacion;
    private LocalDateTime fechaResolucion;
    private String observaciones;
    private String tipoCancelacion;
}
