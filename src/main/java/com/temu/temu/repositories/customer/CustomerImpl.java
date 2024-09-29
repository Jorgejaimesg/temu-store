package com.temu.temu.repositories.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.temu.temu.application.services.ICustomerService;
import com.temu.temu.domain.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerImpl implements ICustomerService{

    
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    @Override
    public Optional<Customer> update(String id, Customer customer) {
        Optional<Customer> customerOld = customerRepository.findById(id);
        if(customerOld.isPresent()){
            Customer customerDb = customerOld.orElseThrow();
            
            customerDb.setFirstName(customer.getFirstName());
            customerDb.setLastName(customer.getLastName());
            customerDb.setPhoneNumber(customer.getPhoneNumber());
            customerDb.setAddress(customer.getAddress());
            customerDb.setEmail(customer.getEmail());
            return Optional.of(customerRepository.save(customerDb));
        }

        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Customer> delete(String id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        customerOptional.ifPresent(customerDb -> {
            customerRepository.delete(customerDb);
        });
        return customerOptional;
    }

}
