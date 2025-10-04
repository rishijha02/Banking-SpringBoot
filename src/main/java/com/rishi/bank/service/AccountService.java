package com.rishi.bank.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.bank.model.Account;
import com.rishi.bank.model.Customer;
import com.rishi.bank.model.Transaction;
import com.rishi.bank.respository.AccountRepository;
import com.rishi.bank.respository.CustomerRepository;
import com.rishi.bank.respository.TransactionRepository;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CustomerRepository customerRepository;

    public List<Account> getAllaccounts()
    {
        return accountRepository.findAll();

    }

    public Optional<Account> getAccById(int id)
    {
        return accountRepository.findById(id);
    }

    public List<Account> getAccByName(String name)
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

    public Account getAccByAccNum( String Accname)
    {
        List<Account> acc= new ArrayList<>();
        acc=accountRepository.findAll();

        Account acc1= new Account();

        for( Account a : acc )
        {
            if ( a.getAccName().toString().equals(Accname))
            {
                acc1=a;
            }
        }
        return acc1;

    }

    public void deleteAccountById(int id)
    {
        accountRepository.deleteById(id);

    }

    public void deleteAccountByAccNum(String AccNum)
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

    public void CreateAccount(Account acc)
    {
        accountRepository.save(acc);
    }

    public void UpdateAccbyId(Account ac)
    {
        List<Account> acc= new ArrayList<>();
        acc=accountRepository.findAll();

        //Account acc1= new Account();

        for( Account a : acc )
        {
            if ( a.getAccId()== ac.getAccId())
            {
                a.setAccName(ac.getAccName());
                a.setAccNum(ac.getAccNum());
                a.setBalance(ac.getBalance());
            }
        }
    

    }

    public void UpdateAccbyName(Account ac)
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
        }
    }

    public void AddBalance(BigDecimal amnt,String Accnum )
    {
        List<Account> acc= accountRepository.findAll();

       // List<Transaction> transactions= transactionRepository.findAll();

        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String formattedDate = sdf.format(dt);

        for(Account ac:acc)
        {
            if (ac.getAccNum().equals(Accnum))
            {
                BigDecimal curramnt=ac.getBalance();
                ac.setBalance(curramnt.add(amnt));
            }
        }

        Transaction tr= new Transaction();

        tr.setAccountNo(Accnum);
        tr.setAmount(amnt);
        tr.setDate(formattedDate);
        tr.setTransactionType("Credit");
        transactionRepository.save(tr);
    }


     public void RemoveBalance(BigDecimal amnt,String Accnum )
    {
        List<Account> acc= accountRepository.findAll();

       // List<Transaction> transactions= transactionRepository.findAll();

        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String formattedDate = sdf.format(dt);

        for(Account ac:acc)
        {
            if (ac.getAccNum().equals(Accnum))
            {
                BigDecimal curramnt=ac.getBalance();
                ac.setBalance(curramnt.add(amnt));
            }
        }

        Transaction tr= new Transaction();

        tr.setAccountNo(Accnum);
        tr.setAmount(amnt);
        tr.setDate(formattedDate);
        tr.setTransactionType("Debit");
        transactionRepository.save(tr);
    }

    public void customeronboard(String custId,String AccNum,String AccName,BigDecimal bal,String branchCode)
    {
        Account acc= new Account();

        acc.setAccName(AccName);
        acc.setAccNum(AccNum);
        acc.setBalance(bal);
        acc.setCstmrId(custId);
        acc.setBranchCode(branchCode);
        accountRepository.save(acc);

        Customer cst= new Customer();

   
        cst.setCustomerId(custId);
        cst.setCustName(AccName);
        customerRepository.save(cst);
    }

    public List<Account> findAllAccountByBranch( String brnchCode)
    {
        List<Account> AllAccnts= new ArrayList<>();

        AllAccnts=accountRepository.findAll();

        List<Account> AllBrnchAccnt=new ArrayList<>();

        for(Account acc:AllAccnts)
        {
            if(acc.getBranchCode().equals(brnchCode))
            {
                AllBrnchAccnt.add(acc);
            }
        }
        return AllBrnchAccnt;
    }
}
