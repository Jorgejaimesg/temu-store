package com.temu.temu.repositories.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import com.temu.temu.application.services.IProductService;
import com.temu.temu.domain.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductImpl implements IProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOld = productRepository.findById(id);
        if(productOld.isPresent()){
            Product productDb = productOld.orElseThrow();
            
            productDb.setName(product.getName());
            productDb.setCategory(product.getCategory());
            productDb.setBarcode(product.getBarcode());
            productDb.setSalePrice(product.getSalePrice());
            productDb.setStockQuantity(product.getStockQuantity());
            productDb.setStatus(product.getStatus());
            return Optional.of(productRepository.save(productDb));
        }

        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        productOptional.ifPresent(productDb -> {
            productRepository.delete(productDb);
        });
        return productOptional;
    }
}
