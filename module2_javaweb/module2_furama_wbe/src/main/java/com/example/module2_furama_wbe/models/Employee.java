package com.example.module2_furama_wbe.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employee_id;
    @Column(name = "employee_name")
    private String employee_name;
    @Column(name = "employee_birthday")
    @DateTimeFormat(pattern = "dd:MM:yyyy")
    private LocalDate employee_birthday;
    @Column(name = "employee_idcard")
    private String employee_idcard;
    @Column(name = "employee_salary")
    private Double employee_salary;
    @Column(name = "employee_phone")
    private String employee_phone;
    @Column(name = "employee_email")
    private String employee_email;
    @Column(name = "employee_address")
    private String employee_address;
    @OneToMany(mappedBy = "employee")
    private List<Contract> contracts;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "edu_bg_id")
    private EduBackground eduBackground;
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    public Employee() {
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public LocalDate getEmployee_birthday() {
        return employee_birthday;
    }

    public void setEmployee_birthday(LocalDate employee_birthday) {
        this.employee_birthday = employee_birthday;
    }

    public String getEmployee_idcard() {
        return employee_idcard;
    }

    public void setEmployee_idcard(String employee_idcard) {
        this.employee_idcard = employee_idcard;
    }

    public Double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EduBackground getEduBackground() {
        return eduBackground;
    }

    public void setEduBackground(EduBackground eduBackground) {
        this.eduBackground = eduBackground;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
