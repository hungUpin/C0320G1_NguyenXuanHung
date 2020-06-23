package com.example.customermanagerspringboot.services;

import com.example.customermanagerspringboot.models.Customer;
import com.example.customermanagerspringboot.models.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();

    Customer findCustomerById(Long id);

    void saveCustomer(Customer customer);

    void removeCustomer(Long id);
    List<Customer> findAllCustomerByProvince(Province province);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllCustomerByFirstName(String firstName,Pageable pageable);
}
