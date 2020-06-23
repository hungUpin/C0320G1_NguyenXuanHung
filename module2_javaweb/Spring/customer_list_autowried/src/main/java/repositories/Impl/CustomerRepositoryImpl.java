package repositories.Impl;

import models.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static Map<Integer,Customer> customerList;
    static {
        customerList = new HashMap<>();
        customerList.put(1,new Customer(1,"Nguyen Van A","abc@gamil.com","Da Nang"));
        customerList.put(2,new Customer(2,"Nguyen Van BA","abc@gamil.com","Da Nang"));
        customerList.put(3,new Customer(3,"Nguyen Van C","abc@gamil.com","Da Nang"));
        customerList.put(4,new Customer(4,"Nguyen Van D","abc@gamil.com","Da Nang"));
        customerList.put(5,new Customer(5,"Nguyen Van E","abc@gamil.com","Da Nang"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerList.values());
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void save(Customer customer) {
        customerList.put(customer.getId(),customer);
    }

    @Override
    public void deleteById(int id) {
        customerList.remove(id);
    }

}
