package com.shufitapp.shufit.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CabeceraFactura")
@Data
public class CabeceraFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cabecera_factura")
    private Integer idCabeceraFactura;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "nombre_gimnasio")
    private String nombreGimnasio;

    @Column(name = "direccion_gimnasio")
    private String direccionGimnasio;

    @Column(name = "informacion_adicional", columnDefinition = "TEXT")
    private String informacionAdicional;

}
