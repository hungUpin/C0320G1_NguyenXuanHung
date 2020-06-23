package com.example.customermanagerspringboot.services.Impl;

import com.example.customermanagerspringboot.models.Customer;
import com.example.customermanagerspringboot.repositories.CustomerRepository;
import com.example.customermanagerspringboot.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
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
    public void removeCustomer(Long id) {
        customerRepository.remove(id);
    }
}
