package service;

import model.Customer;

import java.util.ArrayList;
import java.util.Queue;

public interface Booking4DCinemaInterface {
    void addCustomerBookCinema(Customer customer);
    Queue<Customer> getAllCustomerBooked();
}
