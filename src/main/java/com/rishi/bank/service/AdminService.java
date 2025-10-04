package com.rishi.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.bank.model.Admin;
import com.rishi.bank.model.Bank;
import com.rishi.bank.model.Branch;
import com.rishi.bank.model.Employee;
//import com.rishi.bank.model.Branch;
import com.rishi.bank.respository.AdminRepository;
import com.rishi.bank.respository.EmployeeRepository;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    BankService bankService;

    @Autowired
    BranchService branchService;

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Admin> findAllAdmins()
    {   
        return adminRepository.findAll();
        
    }

    public Optional<Admin> findAdminByAdminId( String adminId)
    {
        return adminRepository.findById(adminId);
    }

    public List<Branch> findBrnchByBnkName(String BankName)
    {
        Bank bnk= bankService.findBanksByName(BankName);

        List<Branch> allbranch=new ArrayList<>();

        allbranch = branchService.findallbranchbyBnkCode(bnk.getBankCode());

        return allbranch;
        
    }

    public List<Employee> findEmployeesByBankName(String BankName)
    {
        Bank bnk= bankService.findBanksByName(BankName);

        List<Employee> allemployee=new ArrayList<>();
        
        List<Branch> allbranch=new ArrayList<>();

        allbranch = branchService.findallbranchbyBnkCode(bnk.getBankCode());

        for(Branch brn:allbranch)
        {
            allemployee=employeeRepository.findAllByBrnchCode(brn.getBranchCode()).stream().toList();
        }

        

        return allemployee;
        
    }

}
