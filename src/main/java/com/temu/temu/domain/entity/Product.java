package com.temu.temu.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(length = 150)
    private String barcode;

    @Column(columnDefinition = "DECIMAL(16,2)", nullable = false)
    private float salePrice;

    @Column(nullable = false)
    private int stockQuantity;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private int status;

    @OneToMany(mappedBy = "product")
    private List<SaleProduct> saleProducts;
}