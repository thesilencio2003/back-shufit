package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DevolucionDTO {

    private Integer idDevolucion;
    private Integer idFactura;
    private LocalDateTime fechaSolicitud;
    private String motivo;
    private String estadoDevolucion;
    private LocalDateTime fechaResolucion;
    private String observaciones;

}
