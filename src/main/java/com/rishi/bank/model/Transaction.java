package com.rishi.bank.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {

    public String getAccountNo() {
        return accountNo;
    }
    public Transaction(String accountNo, BigDecimal amount, String date, Integer transactionNo,
            String transactionType) {
        this.accountNo = accountNo;
        this.amount = amount;
        this.date = date;
        this.transactionNo = transactionNo;
        this.transactionType = transactionType;
    }
    public Transaction() {
    }
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Integer getTransactionNo() {
        return transactionNo;
    }
    public void setTransactionNo(Integer transactionNo) {
        this.transactionNo = transactionNo;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    String accountNo;
    BigDecimal amount;
    String date;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer transactionNo;
    String transactionType;

    

}
