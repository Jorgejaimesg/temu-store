package com.temu.temu.infraestructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.temu.temu.application.services.ISaleProductService;
import com.temu.temu.domain.entity.SaleProduct;
import com.temu.temu.domain.entity.SaleProductId;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/saleProduct")
public class SaleProductController {
    @Autowired
    private ISaleProductService saleProductService;

    @GetMapping
    public List<SaleProduct> list() {
        return saleProductService.findAll();
    }

    @GetMapping("/{saleid}/{productid}")

    public ResponseEntity<?> view(@PathVariable Long saleid, @PathVariable Long productid){
        SaleProductId saleProductId = new SaleProductId(saleid, productid);
        Optional<SaleProduct> saleProductOptional = saleProductService.findById(saleProductId);
        if(saleProductOptional.isPresent()){
            return ResponseEntity.ok(saleProductOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create (@RequestBody SaleProduct saleProduct){
        return ResponseEntity.status(HttpStatus.CREATED).body(saleProductService.save(saleProduct));
    }

        
    @PutMapping("/{saleid}/{productid}")
    public ResponseEntity<?> update(@RequestBody SaleProduct saleProduct,@PathVariable Long saleid, @PathVariable Long productid) {
        SaleProductId saleProductId = new SaleProductId(saleid, productid);
        Optional<SaleProduct> saleProductOptional = saleProductService.update(saleProductId, saleProduct);
        if (saleProductOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(saleProductOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{saleid}/{productid}")
    public ResponseEntity<?> delete(@PathVariable Long saleid, @PathVariable Long productid) {
        SaleProductId saleProductId = new SaleProductId(saleid, productid);
        Optional<SaleProduct> saleProductOptional = saleProductService.delete(saleProductId);
        if (saleProductOptional.isPresent()) {
            return ResponseEntity.ok(saleProductOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
