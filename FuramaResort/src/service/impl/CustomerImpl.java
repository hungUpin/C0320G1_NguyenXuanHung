package service.impl;

import exception.*;
import model.Customer;
import service.CustomerInterface;

import java.util.Scanner;

public class CustomerImpl implements CustomerInterface {
    @Override
    public Customer addNewCustomer() {
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer();
        while (true){
            try{
                System.out.println("Enter Customer name: ");
                customer.setCustomerName(NameException.nameException());
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        while (true){
            try{
                System.out.println("Enter Day of birth: ");
                customer.setDayOfBirth(BirthdayException.checkBirthdayException());
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        while (true){
            try{
                System.out.println("Enter customer gender: ");
                customer.setGender(GenderException.checkGenderException());
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Enter ID number: ");
        customer.setIdNumber(sc.nextLine());
        System.out.println("Enter phone number: ");
        customer.setPhoneNumber(sc.nextLine());
        while (true){
            try{
                System.out.println("Enter email: ");
                customer.setEmail(EmailException.emailException());
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Enter type of customer: ");
        customer.setTypeOfCustomer(sc.nextLine());
        System.out.println("Enter address");
        customer.setAddress(sc.nextLine());
        System.out.println("--------------------------------------------");
        return customer;
    }
}
