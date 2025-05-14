package com.shufitapp.shufit.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String categoria;
    private String imagenUrl;

}
