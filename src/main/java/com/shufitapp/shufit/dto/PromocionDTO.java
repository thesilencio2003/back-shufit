package com.shufitapp.shufit.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PromocionDTO {
    private Integer idPromocion;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String tipoDescuento;
    private Double valorDescuento;
    private String aplicaA;
    private String codigoPromocion;
}
