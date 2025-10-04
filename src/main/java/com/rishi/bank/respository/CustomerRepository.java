package com.rishi.bank.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.bank.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByCustomerId(String customerId);

}
