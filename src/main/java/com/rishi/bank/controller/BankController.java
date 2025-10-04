package com.rishi.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.bank.model.Bank;
import com.rishi.bank.service.BankService;

@RestController
public class BankController {

    @Autowired
    BankService bankService;

    @GetMapping("/bank")
    public List<Bank> allbanks()
    {
        return bankService.findallbanks();
    }

    @GetMapping("/bank/bankcode/{id}")
    public Optional<Bank> Bankbybankcode(@PathVariable int id)
    {
        return bankService.findbyBnkcode(id);
    }


    @PostMapping("/bank/Createbank")
    public List<Bank> CreateBank(@RequestBody Bank bnk)
    {
        bankService.createbank(bnk);
        return bankService.findallbanks();
    }
     
    @PutMapping("/bank/updatebnk")
    public List<Bank> UpdateBank(@RequestBody Bank bnk)
    {
        bankService.updateBankbyId(bnk);
        return bankService.findallbanks();
    }

    @PutMapping("/bank/deletebnk/{id}")
    public List<Bank> DeleteBank(int id)
    {
        bankService.deletebankbyBnkCode(id);
        return bankService.findallbanks();
    }

}
