package com.rishi.bank.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.bank.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,String> {

}
