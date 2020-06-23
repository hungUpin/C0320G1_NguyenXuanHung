package com.example.customermanagerspringboot.services;

import com.example.customermanagerspringboot.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();

    Customer findCustomerById(Long id);

    void saveCustomer(Customer customer);

    void removeCustomer(Long id);
}
