package com.example.module2_furama_wbe.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "divisions")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long division_id;
    @Column(name = "division_name")
    private String division_name;
    @OneToMany(mappedBy = "division")
    List<Employee> employeeList;

    public Division() {
    }

    public Long getDivision_id() {
        return division_id;
    }

    public void setDivision_id(Long division_id) {
        this.division_id = division_id;
    }

    public String getDivision_name() {
        return division_name;
    }

    public void setDivision_name(String division_name) {
        this.division_name = division_name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
