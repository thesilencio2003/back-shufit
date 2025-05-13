package com.shufitapp.shufit.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class PlanEntrenamientoDTO {

    private Integer idPlan;
    private String nombrePlan;
    private String descripcion;
    private Integer duracionDias;
    private BigDecimal precio;

}
