package com.temu.temu.repositories.customer;

import org.springframework.data.repository.CrudRepository;

import com.temu.temu.domain.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>{

}
