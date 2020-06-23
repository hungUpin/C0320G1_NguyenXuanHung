package com.example.customer_mangerment.services;

import com.example.customer_mangerment.models.Customer;
import com.example.customer_mangerment.repositories.CustomerRepository;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();
    Customer findCustomerById(Long id);
    void deleteCustomerById(Long id);
    void saveCustomer(Customer customer);
}
