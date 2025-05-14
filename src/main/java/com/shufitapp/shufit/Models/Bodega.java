package com.shufitapp.shufit.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bodega")
@Data
public class Bodega {
      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bodega")
    private Integer idBodega;

    @Column(name = "nombre", unique = true, nullable = false, length = 100)
    private String nombre;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
}
