package com.rishi.bank.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.bank.model.Employee;
import com.rishi.bank.respository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findallemployee()
    {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findByEmpId(String empId)
    {
        return employeeRepository.findAllByEmployeeId(empId);
    }

}
