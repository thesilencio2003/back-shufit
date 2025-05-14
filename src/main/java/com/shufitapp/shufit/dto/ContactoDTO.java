package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ContactoDTO {

    private Integer idContacto;
    private String nombre;
    private String email;
    private String telefono;
    private String asunto;
    private String mensaje;
    private LocalDateTime fechaContacto;
    private String estadoContacto;

}
