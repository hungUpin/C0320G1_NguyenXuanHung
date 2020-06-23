package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put(1, new Customer(1, "Nguyen Van A", "abc@gmail.com", "Da Nang"));
        customerMap.put(2, new Customer(2, "Nguyen Van B", "abcd@gmail.com", "Ha Noi"));
        customerMap.put(3, new Customer(3, "hello", "hello123@gmail.com", "Quy Nhon"));
        customerMap.put(4, new Customer(4, "xin chào", "xincaho@yahoo.com", "Quảng Ngãi"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMap.put(customer.getCustomerID(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        customerMap.put(id, customer);
    }

    @Override
    public void removeCustomer(int id) {
        customerMap.remove(id);
    }
}
