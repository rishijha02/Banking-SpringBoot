package com.rishi.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer CstId;

    String CustName;
    String customerId;
    public Customer() {
    }
    
    public Integer getCstId() {
        return CstId;
    }

    public void setCstId(Integer cstId) {
        CstId = cstId;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Customer(Integer cstId, String custName, String custId) {
        CstId = cstId;
        CustName = custName;
        customerId = custId;
    }
    

    


}
