package com.temu.temu.repositories.saleproduct;

import org.springframework.data.repository.CrudRepository;

import com.temu.temu.domain.entity.SaleProduct;
import com.temu.temu.domain.entity.SaleProductId;

public interface SaleProductRepository extends CrudRepository<SaleProduct, SaleProductId> {

}
