package com.temu.temu.application.services;

import java.util.List;
import java.util.Optional;

import com.temu.temu.domain.entity.Sale;

public interface ISaleService {
    List<Sale> findAll();

    Optional<Sale> findById(Long id);

    Sale save(Sale Sale);

    Optional<Sale> update(Long id, Sale sale);

    Optional<Sale> delete(Long id);
}
