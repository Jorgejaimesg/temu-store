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

import com.temu.temu.application.services.ICustomerService;
import com.temu.temu.domain.entity.Customer;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public List<Customer> list() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable String id){
        Optional<Customer> customerOptional = customerService.findById(id);
        if(customerOptional.isPresent()){
            return ResponseEntity.ok(customerOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create (@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customer));
    }

        
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Customer product, @PathVariable String id) {
        Optional<Customer> productOptional = customerService.update(id, product);
        if (productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Customer> productOptional = customerService.delete(id);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
