package com.temu.temu.domain.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @Column(length = 20)
    private String id;

    @Column(length = 40, nullable = false)
    private String firstName;

    @Column(length = 100, nullable = false)
    private String lastName;

    @Column(columnDefinition = "DECIMAL(10,0)", nullable = false)
    private float phoneNumber;

    @Column(length = 80)
    private String address;

    @Column(length = 70)
    private String email;


    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Sale> sales;

}