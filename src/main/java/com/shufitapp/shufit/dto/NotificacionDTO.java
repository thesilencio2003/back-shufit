package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NotificacionDTO {

    private Integer idNotificacion;
    private Integer idUsuario;
    private String tipoNotificacion;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private boolean leida;
    private String tipoEntidadRelacionada;
    private Integer idEntidadRelacionada;    

}
