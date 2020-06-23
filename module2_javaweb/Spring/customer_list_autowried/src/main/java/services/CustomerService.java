package services;

import models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer findCustomerById( int id);
    void addNewCustomer(Customer customer);
    void deleteCustomerById(int id);
}
