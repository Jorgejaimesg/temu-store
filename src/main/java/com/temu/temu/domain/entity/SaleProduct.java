package com.temu.temu.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "compras_productos")
@Data
public class SaleProduct {
    @EmbeddedId
    private SaleProductId id;

    @ManyToOne
    @MapsId("saleId")
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @Column(columnDefinition="DECIMAL(16,2)", nullable = false)
    private float total;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private int status;

}