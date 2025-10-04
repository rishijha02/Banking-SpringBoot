package com.rishi.bank.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.bank.model.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
