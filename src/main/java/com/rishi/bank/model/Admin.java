package com.rishi.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Admin {

    @Id
    String adminId;
    String adminName;
    String bankCode;


}
