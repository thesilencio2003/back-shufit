package com.shufitapp.shufit.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "stock", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_producto", "id_bodega"})})
@Data
public class Stock {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stock")
    private Integer idStock;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_STOCK_PRODUCTO"))
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_bodega", nullable = false, foreignKey = @ForeignKey(name = "FK_STOCK_BODEGA"))
    private Bodega bodega;

    @Column(name = "cantidad", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer cantidad;

}
