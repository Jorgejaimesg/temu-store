package com.temu.temu.repositories.sale;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temu.temu.application.services.ISaleService;
import com.temu.temu.domain.entity.Sale;

@Service
public class SaleImpl implements ISaleService{

    @Autowired
    private SaleRepository saleRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Sale> findAll() {
        return (List<Sale>) saleRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Sale> findById(Long id) {
        return saleRepository.findById(id);
    }

    @Transactional
    @Override
    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    @Transactional
    @Override
    public Optional<Sale> update(Long id, Sale sale) {
        Optional<Sale> saleOld = saleRepository.findById(id);
        if(saleOld.isPresent()){
            Sale saleDb = saleOld.orElseThrow();
            
            saleDb.setCustomer(sale.getCustomer());
            saleDb.setDate(sale.getDate());
            saleDb.setPaymentMethod(sale.getPaymentMethod());
            saleDb.setComment(sale.getComment());
            saleDb.setStatus(sale.getStatus());
            return Optional.of(saleRepository.save(saleDb));
        }

        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Sale> delete(Long id) {
        Optional<Sale> saleOptional = saleRepository.findById(id);
        saleOptional.ifPresent(saleDb -> {
            saleRepository.delete(saleDb);
        });
        return saleOptional;
    }
}
