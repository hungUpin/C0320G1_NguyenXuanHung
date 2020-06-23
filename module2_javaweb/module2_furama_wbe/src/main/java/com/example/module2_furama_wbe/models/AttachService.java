package com.example.module2_furama_wbe.models;

import javax.persistence.*;

@Entity
@Table(name = "attachservices")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private Long attach_service_id;
    @Column(name = "attach_service_name")
    private String attach_service_name;
    @Column(name = "attach_service_price")
    private Double attach_service_price;
    @Column(name = "attach_service_unit")
    private Integer attach_service_unit;
    @Column(name = "attach_service_status")
    private Boolean attach_service_status = true;

    public AttachService() {
    }

    public Long getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(Long attach_service_id) {
        this.attach_service_id = attach_service_id;
    }

    public String getAttach_service_name() {
        return attach_service_name;
    }

    public void setAttach_service_name(String attach_service_name) {
        this.attach_service_name = attach_service_name;
    }

    public Double getAttach_service_price() {
        return attach_service_price;
    }

    public void setAttach_service_price(Double attach_service_price) {
        this.attach_service_price = attach_service_price;
    }

    public Integer getAttach_service_unit() {
        return attach_service_unit;
    }

    public void setAttach_service_unit(Integer attach_service_unit) {
        this.attach_service_unit = attach_service_unit;
    }

    public Boolean getAttach_service_status() {
        return attach_service_status;
    }

    public void setAttach_service_status(Boolean attach_service_status) {
        this.attach_service_status = attach_service_status;
    }
}
