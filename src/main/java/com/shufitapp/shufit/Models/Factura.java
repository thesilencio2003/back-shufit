package com.shufitapp.shufit.Models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Factura")
@Data
public class Factura {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Integer idFactura;

    @ManyToOne
    @JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "FK_FACTURA_CLIENTE"))
    private Cliente cliente;

    @CreationTimestamp
    @Column(name = "fecha_emision")
    private LocalDateTime fechaEmision;

    @Column(name = "total_factura", precision = 10, scale = 2)
    private Double totalFactura;

    @Column(name = "estado_pago", length = 50)
    private String estadoPago;

    @Column(name = "metodo_pago", length = 50)
    private String metodoPago;

    @OneToOne
    @JoinColumn(name = "id_cabecera_factura", unique = true, foreignKey = @ForeignKey(name = "FK_FACTURA_CABECERA"))
    private CabeceraFactura cabeceraFactura;
}
