package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FacturaDTO {

    private Integer idFactura;
    private Integer clienteId;
    private LocalDateTime fechaEmision;
    private Double totalFactura;
    private String estadoPago;
    private String metodoPago;
    private Integer idCabeceraFactura;

}
