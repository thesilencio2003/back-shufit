package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SeguimientoEnvioDTO {

    private Integer idSeguimiento;
    private Integer idFactura;
    private String companiaEnvio;
    private String numeroGuia;
    private LocalDateTime fechaEnvio;
    private String estadoEnvio;
    private String direccionEntrega;

}
