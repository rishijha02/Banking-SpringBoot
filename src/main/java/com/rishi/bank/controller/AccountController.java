package com.rishi.bank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.bank.model.Account;
import com.rishi.bank.respository.AccountRepository;
//import com.rishi.bank.respository.AccountRepository;
//import com.rishi.bank.service.AccountService;

@RestController
public class AccountController {

  //  @Autowired
   // AccountService accountService; 

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/accounts")
    public List<Account> getAllaccounts()
    {
        return accountRepository.findAll();

    }

    @GetMapping("/accbyid/{id}")
   public Optional<Account> getAccById(@PathVariable int id)
    {
        return accountRepository.findById(id);
    }

    @GetMapping("/accbynm/{name}")
    public List<Account> getAccByName(@PathVariable String name)
    {
        List<Account> acc= new ArrayList<>();
        acc=accountRepository.findAll();

        List<Account> acc1= new ArrayList<>();

        for( Account a : acc )
        {
            if ( a.getAccName().toString().equals(name))
            {
                acc1.add(a);
            }
        }
        return acc1;
    }

    // @GetMapping("/accounts/{num}")
    // public void createaccount(String num)
    // {
    //     accountService.getAccByAccNum(num);

    // }


    @GetMapping("/accbynum/{Accnum}")
    public Account getAccByAccNum(@PathVariable String Accnum)
    {
        List<Account> acc= new ArrayList<>();
        acc=accountRepository.findAll();

        Account acc1= new Account();

        for( Account a : acc )
        {
            if ( a.getAccNum().toString().equals(Accnum))
            {
                acc1=a;
            }
        }
        return acc1;

    }

    @PostMapping("/createacc")
    public void CreateAccount(@RequestBody  Account acc)
    {
        accountRepository.save(acc);
    }

    @PutMapping("/updateaccount/{id}")
    public List<Account> UpdateAccbyId(@PathVariable int id , @RequestBody Account ac)
    {
        List<Account> acc= new ArrayList<>();
        acc=accountRepository.findAll();

        //Account acc1= new Account();

        for( Account a : acc )
        {
            if ( a.getAccId()== id)
            {
                a.setAccName(ac.getAccName());
                a.setAccNum(ac.getAccNum());
                a.setBalance(ac.getBalance());
                
            }
            accountRepository.save(a);

        }
        

        return acc;
    

    }

    @PutMapping("/updateaccount")
    public void UpdateAccbyName(@RequestBody Account ac)
    {
        List<Account> acc= new ArrayList<>();
        acc=accountRepository.findAll();

        //Account acc1= new Account();

        for( Account a : acc )
        {
            if ( a.getAccName().toString().equals( ac.getAccName()))
            {
                a.setAccName(ac.getAccName());
                a.setAccNum(ac.getAccNum());
                a.setBalance(ac.getBalance());
            }
            accountRepository.save(a);
        }
    }


    @DeleteMapping("/del/{id}")
    public void deleteAccountById(@PathVariable int id)
    {
        accountRepository.deleteById(id);
 
    }

    @DeleteMapping("/delete/{AccNum}")
    public void deleteAccountByAccNum(@PathVariable String AccNum)
    {
        List<Account> acc= new ArrayList<>();
        acc=accountRepository.findAll();

        //Account acc1= new Account();

        for( Account a : acc )
        {
            if ( a.getAccName().toString().equals(AccNum))
            {
                acc.remove(a);
            }
        }
        
    }

}
