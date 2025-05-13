package com.shufitapp.shufit.Models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "recepcionista")
@Data
public class Recepcionista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecepcionista;

    @OneToOne
    @JoinColumn(name = "id_persona", unique = true, nullable = false, foreignKey = @ForeignKey(name = "FK_RECEPCIONISTA_PERSONA"))
    private Persona persona;

}
