package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EstadisticaDTO {

     private Integer idEstadistica;
    private LocalDateTime fechaCalculo;
    private Integer totalClientesActivos;
    private Double promedioCitasSemana;
    private Double ingresosMesActual;
    private Integer nuevosClientesMesActual;
    private Integer membresiasActivas;

}
