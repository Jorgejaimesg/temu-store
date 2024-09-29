package com.temu.temu.application.services;

import java.util.List;
import java.util.Optional;

import com.temu.temu.domain.entity.Category;

public interface ICategoryService {
    List<Category> findAll();

    Optional<Category> findById(Long id);

    Category save(Category category);

    Optional<Category> update(Long id, Category category);

    Optional<Category> delete(Long id);
}
