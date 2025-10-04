package com.rishi.bank.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.bank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

}
