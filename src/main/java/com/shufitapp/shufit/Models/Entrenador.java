package com.shufitapp.shufit.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "entrenador")
@Data
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEntrenador;

    @OneToOne
    @JoinColumn(name = "id_persona", unique = true, nullable = false, foreignKey = @ForeignKey(name = "FK_ENTRENADOR_PERSONA"))
    private Persona persona;

    @Column(name = "especializacion", length = 255)
    private String especializacion;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;    

}
