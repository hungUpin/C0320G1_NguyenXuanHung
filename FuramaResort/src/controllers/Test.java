package controllers;

import exception.BirthdayException;
import exception.EmailException;
import exception.GenderException;
import service.CustomerInterface;
import service.impl.CustomerImpl;

public class Test {
    public static void main(String[] args) throws EmailException, GenderException, BirthdayException {
        CustomerInterface customerInterface = new CustomerImpl();
        customerInterface.addNewCustomer();
    }
}
