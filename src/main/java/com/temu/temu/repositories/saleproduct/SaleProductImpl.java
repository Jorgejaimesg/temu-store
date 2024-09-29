package com.temu.temu.repositories.saleproduct;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temu.temu.application.services.ISaleProductService;
import com.temu.temu.domain.entity.SaleProduct;
import com.temu.temu.domain.entity.SaleProductId;

@Service
public class SaleProductImpl implements ISaleProductService{

    @Autowired
    private SaleProductRepository saleProductRepository;

    @Transactional(readOnly = true)
    @Override
    public List<SaleProduct> findAll() {
        return (List<SaleProduct>)saleProductRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<SaleProduct> findById(SaleProductId id) {
        return saleProductRepository.findById(id);
    }

    @Transactional
    @Override
    public SaleProduct save(SaleProduct saleProduct) {
        return saleProductRepository.save(saleProduct);
    }

    @Transactional
    @Override
    public Optional<SaleProduct> update(SaleProductId id, SaleProduct saleProduct) {
        Optional<SaleProduct> saleProductOld = saleProductRepository.findById(id);
        if(saleProductOld.isPresent()){
            SaleProduct saleProductDb = saleProductOld.orElseThrow();
            
            saleProductDb.setSale(saleProduct.getSale());
            saleProductDb.setProduct(saleProduct.getProduct());
            saleProductDb.setQuantity(saleProduct.getQuantity());
            saleProductDb.setTotal(saleProduct.getTotal());
            saleProductDb.setStatus(saleProduct.getStatus());
            return Optional.of(saleProductRepository.save(saleProductDb));
        }

        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<SaleProduct> delete(SaleProductId id) {
        Optional<SaleProduct> saleProductOptional = saleProductRepository.findById(id);
        saleProductOptional.ifPresent(saleProductDb -> {
            saleProductRepository.delete(saleProductDb);
        });
        return saleProductOptional;
    }
}
