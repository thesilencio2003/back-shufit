package com.shufitapp.shufit.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClienteDTO {

    private Integer idCliente;
    private PersonaDTO persona;
    private LocalDate fechaInscripcion;
    private String objetivoPrincipal;
    private String informacionAdicional;
}
