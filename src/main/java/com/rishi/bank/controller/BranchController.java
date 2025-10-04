package com.rishi.bank.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.rishi.bank.model.Bank;
import com.rishi.bank.model.Branch;
import com.rishi.bank.service.BranchService;

@RestController
public class BranchController {

    @Autowired
    BranchService branchService;

     @GetMapping("/branch")
    public List<Branch> allbranches()
    {
        return branchService.findallbrnch();
    }

    @GetMapping("/branch/{id}")
    public List<Branch> BranchbyBankcode(@PathVariable String id)
    {
        return branchService.findallbranchbyBnkCode(id);
    }

 
    @PostMapping("/branch/Createbranch")
    public List<Branch> CreateBranch(@RequestBody Branch brnch)
    {
        branchService.CreateBranch(brnch);
        return branchService.findallbrnch();
    }
     
    // @PutMapping("/updatebnk")
    // public List<Branch> UpdateBranch(@RequestBody Bank bnk)
    // {
    //     branchService.updateBankbyId(bnk);
    //     return branchService.findallbanks();
    // }

    // @PutMapping("/deletebnk/{id}")
    // public List<Branch> DeleteBranch(int id)
    // {
    //     branchService.deletebankbyBnkCode(id);
    //     return branchService.findallbanks();
    // }

}
