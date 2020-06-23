package com.example.module2_furama_wbe.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "attachservicedetails")
public class AttachServiceDetail {
    @EmbeddedId
    private ContractDetailKey id;
    @ManyToOne
    @MapsId("contract_id")
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @MapsId("attach_service_id")
    @JoinColumn(name = "attach_service_id")
    private AttachService attachService;

    @Column(name = "quantity")
    private Integer quantity;

    public AttachServiceDetail() {
    }

    public ContractDetailKey getId() {
        return id;
    }

    public void setId(ContractDetailKey id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
