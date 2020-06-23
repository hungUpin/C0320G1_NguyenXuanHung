package com.example.module2_furama_wbe.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "edubackgrounds")
public class EduBackground {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edu_bg_id")
    private String edu_bg_id;
    @Column(name = "edu_degree")
    private String edu_degree;
    @OneToMany(mappedBy = "eduBackground")
    List<Employee> employees;

    public EduBackground() {
    }

    public String getEdu_bg_id() {
        return edu_bg_id;
    }

    public void setEdu_bg_id(String edu_bg_id) {
        this.edu_bg_id = edu_bg_id;
    }

    public String getEdu_degree() {
        return edu_degree;
    }

    public void setEdu_degree(String edu_degree) {
        this.edu_degree = edu_degree;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
