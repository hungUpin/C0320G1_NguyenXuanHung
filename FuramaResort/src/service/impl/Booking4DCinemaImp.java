package service.impl;

import model.Customer;
import service.Booking4DCinemaInterface;

import java.util.LinkedList;
import java.util.Queue;

public class Booking4DCinemaImp implements Booking4DCinemaInterface {
    private static Queue<Customer> customerQueue = new LinkedList<>();
    public void addCustomerBookCinema(Customer customer) {
        customerQueue.add(customer);
    }

    @Override
    public Queue<Customer> getAllCustomerBooked() {
        return customerQueue;
    }
}
