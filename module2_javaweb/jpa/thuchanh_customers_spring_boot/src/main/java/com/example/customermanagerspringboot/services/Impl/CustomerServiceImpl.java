package com.example.customermanagerspringboot.services.Impl;

import com.example.customermanagerspringboot.models.Customer;
import com.example.customermanagerspringboot.models.Province;
import com.example.customermanagerspringboot.repositories.CustomerRepository;
import com.example.customermanagerspringboot.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public List<Customer> findAllCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void removeCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAllCustomerByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllCustomerByFirstName(String firstName, Pageable pageable) {
        return customerRepository.findAllByFirstNameContaining(firstName,pageable);
    }
}
