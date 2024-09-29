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
@Table(name = "sale")
@Data
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(columnDefinition="datetime",nullable = false)
    private String date;

    @Column(length = 1, nullable = false)
    private int paymentMethod;

    @Column(length = 300)
    private String comment;

    @Column(length = 1, nullable = false)
    private int status;

    @OneToMany(mappedBy = "sale")
    private List<SaleProduct> saleProducts;
}