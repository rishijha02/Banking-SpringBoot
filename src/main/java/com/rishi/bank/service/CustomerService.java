package com.rishi.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.bank.model.Account;
import com.rishi.bank.model.Bank;
import com.rishi.bank.model.Branch;
import com.rishi.bank.model.Customer;
import com.rishi.bank.respository.BankRepository;
import com.rishi.bank.respository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BankRepository bankRepository;

    @Autowired
    BankService bankService;

    @Autowired
    BranchService branchService;

    @Autowired
    AccountService accountService;

    public List<Customer> findAllCustomers()
    {
        return customerRepository.findAll();
    }

    public void createcustomer(Customer cst)
    {
        customerRepository.save(cst);
    }

    public Optional<Customer> findByCustomerId( String cstid)
    {

        return customerRepository.findByCustomerId(cstid);
        // List<Customer> customers=customerRepository.findAll();
        // customerRepository.find

        // System.out.println("customers in bank"+ customers);

        // Customer allcustomers= new Customer();

        // for (Customer cust : customers)
        // {
        //     if(cust.getCustomerId().equals(cstid))
        //     {
        //         allcustomers=cust;
        //     }
            
        // }

        // return allcustomers.;
    }

    public List<Customer> findllCustomersbyBankName(String BankName)
    {
        Bank allbanks=new Bank();

        allbanks=bankService.findBanksByName(BankName);
        String bnkcode=allbanks.getBankCode();


        List<Branch> Allbrnch=new ArrayList<>();

        Allbrnch=branchService.findallbranchbyBnkCode(bnkcode);

        List<Account> AllAcnts= new ArrayList<>();
        AllAcnts = accountService.getAllaccounts();

        List<Customer> customers=new ArrayList<>();

        for (Branch brn:Allbrnch)
        {
            for(Account acc :AllAcnts)
            {
                if(brn.getBranchCode().equals(acc.getBranchCode()))
                {
                    if(findByCustomerId(acc.getCstmrId()).isPresent())
                    {
                        customers=findByCustomerId(acc.getCstmrId()).stream().toList();
                    }
                    
                }
            }
        }

        return customers;
        
    }

}
