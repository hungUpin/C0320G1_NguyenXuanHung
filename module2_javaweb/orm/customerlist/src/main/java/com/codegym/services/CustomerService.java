package com.codegym.services;

import com.codegym.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();
    Customer findCustomerById(Long id);
    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);
}
