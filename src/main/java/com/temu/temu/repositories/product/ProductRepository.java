package com.temu.temu.repositories.product;

import org.springframework.data.repository.CrudRepository;

import com.temu.temu.domain.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
