package com.example.module2_furama_wbe.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long position_id;
    @Column(name = "position_name")
    private String position_name;
    @OneToMany(mappedBy = "position")
    List<Employee> employeeList;

    public Position() {
    }

    public Long getPosition_id() {
        return position_id;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void setPosition_id(Long position_id) {
        this.position_id = position_id;
    }
}
