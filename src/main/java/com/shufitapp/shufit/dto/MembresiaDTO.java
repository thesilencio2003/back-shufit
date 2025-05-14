package com.shufitapp.shufit.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MembresiaDTO {

    private Integer idMembresia;
    private Integer clienteId;
    private String tipoMembresia;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double precio;
    private String estadoMembresia;

}
