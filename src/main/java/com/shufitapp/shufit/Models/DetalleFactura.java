package com.shufitapp.shufit.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DetalleFactura")
@Data
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = false, foreignKey = @ForeignKey(name = "FK_DETALLE_FACTURA"))
    private Factura factura;

    @Column(name = "tipo_item", length = 50)
    private String tipoItem;

    @Column(name = "id_item", nullable = false)
    private Integer idItem;

    @Column(name = "descripcion_item", nullable = false)
    private String descripcionItem;

    @Column(name = "cantidad")
    private Integer cantidad = 1;

    @Column(name = "precio_unitario", precision = 10, scale = 2)
    private Double precioUnitario;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private Double subtotal;

}
