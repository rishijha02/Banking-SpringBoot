package com.rishi.bank.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rishi.bank.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

    Optional<Employee> findAllByEmployeeId(String employeeId);
    Optional<Employee> findAllByBrnchCode(String brnchCode);

}
