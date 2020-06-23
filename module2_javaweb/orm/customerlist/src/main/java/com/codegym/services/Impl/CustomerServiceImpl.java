package com.codegym.services.Impl;

import com.codegym.models.Customer;
import com.codegym.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import com.codegym.repositories.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.remove(id);
    }
}
