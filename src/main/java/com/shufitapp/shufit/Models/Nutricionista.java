package com.shufitapp.shufit.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "nutricionista")
@Data
public class Nutricionista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNutricionista;

    @OneToOne
    @JoinColumn(name = "id_persona", unique = true, nullable = false, foreignKey = @ForeignKey(name = "FK_NUTRICIONISTA_PERSONA"))
    private Persona persona;

    @Column(name = "especialidad", length = 255)
    private String especialidad;

    @Column(name = "cedula_profesional", length = 100, unique = true)
    private String cedulaProfesional;



}
