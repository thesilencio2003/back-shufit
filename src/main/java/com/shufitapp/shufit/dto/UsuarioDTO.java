package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Integer idUsuario;
    private PersonaDTO persona;
    private String nombreUsuario;
    private Integer rolId; 
    private String contrasena;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
