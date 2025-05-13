package com.shufitapp.shufit.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "rol")
@Data
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer idRol;

    @Column(name = "nombre_rol", unique = true, nullable = false, length = 50)
    private String nombreRol;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
}
