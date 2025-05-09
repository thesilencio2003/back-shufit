package com.shufitapp.shufit.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PersonaDTO {

    private Integer idPersona;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String email;
    private String telefono;
    private String direccion;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaActualizacion;
}
