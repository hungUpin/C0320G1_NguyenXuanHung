package com.example.module2_furama_wbe.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "renttypes")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private Long rent_type_id;
    @Column(name = "rent_type_name")
    private String rent_type_name;
    @Column(name = "rent_type_price")
    private Double rent_type_price;
    @OneToMany(mappedBy = "rentType")
    private List<Service> serviceList;

    public RentType() {
    }

    public Long getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(Long rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public String getRent_type_name() {
        return rent_type_name;
    }

    public void setRent_type_name(String rent_type_name) {
        this.rent_type_name = rent_type_name;
    }

    public Double getRent_type_price() {
        return rent_type_price;
    }

    public void setRent_type_price(Double rent_type_price) {
        this.rent_type_price = rent_type_price;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
