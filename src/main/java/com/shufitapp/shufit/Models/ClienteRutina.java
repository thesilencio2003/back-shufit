package com.shufitapp.shufit.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "clienterutina")
@Data
@IdClass(ClienteRutinaId.class)
public class ClienteRutina {

    @Id
    @Column(name = "id_cliente")
    private Integer clienteId;

    @Id
    @Column(name = "id_rutina")
    private Integer rutinaId;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_CLIENTERUTINA_CLIENTE"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_rutina", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_CLIENTERUTINA_RUTINA"))
    private Rutina rutina;

    @Column(name = "fecha_asignacion", nullable = false)
    @CreationTimestamp
    private LocalDateTime fechaAsignacion;

    @Column(name = "posible_fecha_finalizacion")
    private LocalDate posibleFechaFinalizacion;

    @Column(name = "comentarios", columnDefinition = "TEXT")
    private String comentarios;    

}
