package com.rishi.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User_Role {

    @Id
     String username;
     String password;
     String Role;

}
