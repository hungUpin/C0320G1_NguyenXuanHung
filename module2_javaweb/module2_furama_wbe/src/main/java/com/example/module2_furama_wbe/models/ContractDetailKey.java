package com.example.module2_furama_wbe.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ContractDetailKey implements Serializable {
    @Column(name = "contract_id")
    private Long contract_id;
    @Column(name = "attach_service_id")
    private Long attach_service_id;
    // standard constructors, getters, and setters
    // hashcode and equals implementation

    public ContractDetailKey() {
    }

    public Long getContract_id() {
        return contract_id;
    }

    public void setContract_id(Long contract_id) {
        this.contract_id = contract_id;
    }

    public Long getAttach_service_id() {
        return attach_service_id;
    }

    public void setAttach_service_id(Long attach_service_id) {
        this.attach_service_id = attach_service_id;
    }
}
