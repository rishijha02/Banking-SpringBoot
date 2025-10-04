package com.rishi.bank.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bank {

    String bankName;

    
    @Id
    String bankCode;
    Integer bnkadrid;
    public Bank(String bankName, String bankCode, Integer bnkadrid) {
        this.bankName = bankName;
        this.bankCode = bankCode;
        this.bnkadrid = bnkadrid;
    }
    public String getBankName() {
        return bankName;
    }
    public Bank() {
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankCode() {
        return bankCode;
    }
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    public Integer getBnkadrid() {
        return bnkadrid;
    }
    public void setBnkadrid(Integer bnkadrid) {
        this.bnkadrid = bnkadrid;
    }
    


    

    
}
