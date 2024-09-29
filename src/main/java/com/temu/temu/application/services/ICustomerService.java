package com.temu.temu.application.services;

import java.util.List;
import java.util.Optional;

import com.temu.temu.domain.entity.Customer;

public interface ICustomerService {
    List<Customer> findAll();

    Optional<Customer> findById(String id);

    Customer save(Customer customer);

    Optional<Customer> update(String id, Customer customer);

    Optional<Customer> delete(String id);
}
