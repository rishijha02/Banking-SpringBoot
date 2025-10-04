package com.rishi.bank.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.bank.model.Branch;

public interface BranchRepository  extends JpaRepository<Branch,Integer>{

    

}
