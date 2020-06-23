package com.example.module2_furama_wbe.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long contract_id;
    @Column(name = "contract_start_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate contract_start_date;
    @Column(name = "contract_end_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate contract_end_date;
    @Column(name = "contract_deposit")
    private Double contract_deposit;
    @Column(name = "contract_price")
    private Double contract_price;
    //employeeid,customerid,service_id
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    public Contract() {
    }

    public Long getContract_id() {
        return contract_id;
    }

    public void setContract_id(Long contract_id) {
        this.contract_id = contract_id;
    }

    public LocalDate getContract_start_date() {
        return contract_start_date;
    }

    public void setContract_start_date(LocalDate contract_start_date) {
        this.contract_start_date = contract_start_date;
    }

    public LocalDate getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(LocalDate contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    public Double getContract_deposit() {
        return contract_deposit;
    }

    public void setContract_deposit(Double contract_deposit) {
        this.contract_deposit = contract_deposit;
    }

    public Double getContract_price() {
        return contract_price;
    }

    public void setContract_price(Double contract_price) {
        this.contract_price = contract_price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
