package com.shufitapp.shufit.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PlanAlimentacionDTO {

     private Integer idPlan;
    private Integer clienteId;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String objetivo;
    private Integer caloriasDiarias;
    private Double proteinas;
    private Double carbohidratos;
    private Double grasas;
    private String recomendaciones;
}
