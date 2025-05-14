package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data

public class EvaluacionInicialDTO {

    private Integer idEvaluacionInicial;
    private Integer clienteId;
    private LocalDateTime fechaEvaluacion;
    private Double peso;
    private Double altura;
    private Double imc;
    private Double porcentajeGrasa;
    private String medidasAntropometricas;
    private String observaciones;
}
