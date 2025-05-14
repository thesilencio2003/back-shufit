package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class HistorialMedicoDTO {

    private Integer idHistorialMedico;
    private Integer clienteId;
    private LocalDateTime fechaRegistro;
    private String antecedentesMedicos;
    private String alergias;
    private String lesionesPrevias;
    private String medicamentosActuales;
    private String observaciones;

}
