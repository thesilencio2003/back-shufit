package com.shufitapp.shufit.dto;

import lombok.Data;

@Data
public class DetalleFacturaDTO {
    private Integer idDetalle;
    private Integer idFactura;
    private String tipoItem;
    private Integer idItem;
    private String descripcionItem;
    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
}
