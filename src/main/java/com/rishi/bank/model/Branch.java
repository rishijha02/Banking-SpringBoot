package com.rishi.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = 
  { //other constraints
  @UniqueConstraint(name = "UniquebankcodeAndBranchcode", columnNames = { "branchCode", "bankCode" })})
public class Branch {

    @Id
    String branchCode;

    String bankCode;
    Integer addrId;
    String manager; 
    String HeadOffice;
    public Branch(String branchCode, String bankCode, Integer addrId, String manager, String headOffice) {
        this.branchCode = branchCode;
        this.bankCode = bankCode;
        this.addrId = addrId;
        this.manager = manager;
        HeadOffice = headOffice;
    }
    public Branch() {
    }
    public String getBranchCode() {
        return branchCode;
    }
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    public Integer getAddrId() {
        return addrId;
    }
    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }
    public String getManager() {
        return manager;
    }
    public void setManager(String manager) {
        this.manager = manager;
    }
    public String getHeadOffice() {
        return HeadOffice;
    }
    public void setHeadOffice(String headOffice) {
        HeadOffice = headOffice;
    }

    
    


}
