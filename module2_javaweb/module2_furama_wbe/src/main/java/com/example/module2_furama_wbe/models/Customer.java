package com.example.module2_furama_wbe.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customer_id;
    @Column(name = "customer_name")
    private String customer_name;
    @Column(name = "customer_birthday")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate customer_birthday;
    @Column(name = "customer_idcard")
    private String customer_idCard;
    @Column(name = "customer_phone")
    private String email;
    @Column(name = "customer_email")
    private String address;
    @Column(name = "customer_address",columnDefinition = "text")
    private String customer_address;
    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;
    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;
    public Customer() {
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public LocalDate getCustomer_birthday() {
        return customer_birthday;
    }

    public void setCustomer_birthday(LocalDate customer_birthday) {
        this.customer_birthday = customer_birthday;
    }

    public String getCustomer_idCard() {
        return customer_idCard;
    }

    public void setCustomer_idCard(String customer_idCard) {
        this.customer_idCard = customer_idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
