package com.shufitapp.shufit.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AuditoriaDTO {

    private Integer idAuditoria;
    private LocalDateTime fechaHoraEvento;
    private String tipoEvento;
    private String usuario;
    private String entidadAfectada;
    private Integer idEntidadAfectada;
    private String detallesCambio;

}
