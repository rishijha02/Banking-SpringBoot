package com.rishi.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.bank.model.Account;
import com.rishi.bank.model.Transaction;
import com.rishi.bank.respository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountService accountService;

    public List<Transaction> AllTransactionList()
    {
        return  transactionRepository.findAll();
        
    }

    public List<Transaction> findAllTrnsctnByAccNum(String AccNum)
    {
        List<Transaction> allTransactions = transactionRepository.findAll();

        List<Transaction> filteTransactions=new ArrayList<>();

        for (Transaction transaction : allTransactions)
        {
            if(transaction.getAccountNo().equals(AccNum))
            {
                filteTransactions.add(transaction);
            }
        }

        return filteTransactions;

    }

    public List<Transaction> findAllTransactionBybrnchCode (String brnchCode)
    {
        List<Account> AllAccnts= new ArrayList<>();

        AllAccnts=accountService.getAllaccounts();

        List<Transaction> AllTrsnaction=new ArrayList<>();

        for(Account acc: AllAccnts)
        {
            if(acc.getBranchCode().equals(brnchCode))
            {
                String AccNum=acc.getAccNum();
                AllTrsnaction=findAllTrnsctnByAccNum(AccNum);
            }
        }
        return AllTrsnaction;
    }
    


}
