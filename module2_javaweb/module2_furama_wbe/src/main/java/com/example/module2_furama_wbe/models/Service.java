package com.example.module2_furama_wbe.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long service_id;
    @Column(name = "service_name")
    private String service_name;
    @Column(name = "service_area")
    private Double service_area;
    @Column(name = "service_floor")
    private Integer service_floor;
    @Column(name = "service_max_people")
    private Integer service_max_people;
    @Column(name = "service_price")
    private Double service_price;
    @Column(name = "service_status")
    private Boolean service_status =true;
    //renttypeid,servicetypeid
    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;
    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;
    @OneToMany(mappedBy = "service")
    private List<Contract> contracts;
    public Service() {
    }

    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public Double getService_area() {
        return service_area;
    }

    public void setService_area(Double service_area) {
        this.service_area = service_area;
    }

    public Integer getService_floor() {
        return service_floor;
    }

    public void setService_floor(Integer service_floor) {
        this.service_floor = service_floor;
    }

    public Integer getService_max_people() {
        return service_max_people;
    }

    public void setService_max_people(Integer service_max_people) {
        this.service_max_people = service_max_people;
    }

    public Double getService_price() {
        return service_price;
    }

    public void setService_price(Double service_price) {
        this.service_price = service_price;
    }

    public Boolean getService_status() {
        return service_status;
    }

    public void setService_status(Boolean service_status) {
        this.service_status = service_status;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
