package com.rishi.bank.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     int AccId;
    
     String AccName;
     String AccNum;
     BigDecimal balance; 
     String CstmrId;
     String branchCode;

     public Account(int accId, String accName, String accNum, BigDecimal balance, String cstmrId) {
        AccId = accId;
        AccName = accName;
        AccNum = accNum;
        this.balance = balance;
        CstmrId = cstmrId;
     }
     public Account() {
     }


}
