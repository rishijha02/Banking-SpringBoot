package com.rishi.bank.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.bank.model.User_Role;

public interface User_RoleRepository extends JpaRepository<User_Role,String> {
    Optional<User_Role> findByUsername(String username);

}
