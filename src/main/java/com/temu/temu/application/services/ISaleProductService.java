package com.temu.temu.application.services;

import java.util.List;
import java.util.Optional;

import com.temu.temu.domain.entity.SaleProduct;
import com.temu.temu.domain.entity.SaleProductId;

public interface ISaleProductService {
    List<SaleProduct> findAll();

    Optional<SaleProduct> findById(SaleProductId saleProductId);

    SaleProduct save(SaleProduct saleProduct);

    Optional<SaleProduct> update(SaleProductId saleProductId, SaleProduct saleProduct);

    Optional<SaleProduct> delete(SaleProductId saleProductId);
}
