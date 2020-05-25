package controllers;

import exception.BirthdayException;
import exception.EmailException;
import exception.GenderException;
import exception.NameException;
import model.*;
import service.CustomerInterface;
import service.impl.CustomerImp;
import service.impl.VillaServiceImp;
import validation.ValidationTask04;

public class Test {
    public static void main(String[] args) throws EmailException, GenderException, BirthdayException {
        CustomerInterface customerInterface = new CustomerImp();
        customerInterface.addNewCustomer();
    }
}
