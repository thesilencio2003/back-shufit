package com.shufitapp.shufit.dto;

import lombok.Data;

@Data
public class CabeceraFacturaDTO {

    private Integer idCabeceraFactura;
    private String logoUrl;
    private String nombreGimnasio;
    private String direccionGimnasio;
    private String informacionAdicional;
}
