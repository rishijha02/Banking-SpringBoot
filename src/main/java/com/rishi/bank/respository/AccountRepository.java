package com.rishi.bank.respository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<com.rishi.bank.model.Account,Integer> {

}
