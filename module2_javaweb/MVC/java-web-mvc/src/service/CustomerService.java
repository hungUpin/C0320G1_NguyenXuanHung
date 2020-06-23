package service;

import model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void addCustomer(Customer customer);
    Customer findById(int id);
    void updateCustomer(int id, Customer customer);
    void removeCustomer(int id);
}
