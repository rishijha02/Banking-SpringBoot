package com.rishi.bank.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.bank.model.Bank;
import com.rishi.bank.respository.BankRepository;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    public List<Bank> findallbanks()
    {
        return bankRepository.findAll();
    }

    public Optional<Bank> findbyBnkcode(int bnkcode)
    {
        return bankRepository.findById(bnkcode);
    }

    public void createbank(Bank bank)
    {
        bankRepository.save(bank);
    }

    public void deletebankbyBnkCode(int bnkcode)
    {
        bankRepository.deleteById(bnkcode);
    }

    public void updateBankbyId(Bank bnk)
    {
        List<Bank> allbnks= bankRepository.findAll();

        for (Bank b: allbnks)
        {
            if (b.getBankCode()==bnk.getBankCode())
            {
                b.setBankName(bnk.getBankName());
                b.setBnkadrid(bnk.getBnkadrid());
            }
            bankRepository.save(b);
        }
    }

    public Bank findBanksByName(String bnkName)
    {
        List<Bank> allbnks= bankRepository.findAll();

        Bank bnknames=new Bank();

        for(Bank b:allbnks)
        {
            if(b.getBankName().equals(bnkName))
            {
                bnknames=b;
            }
        }
        return bnknames;

    }

}
