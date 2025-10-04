package com.rishi.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishi.bank.model.Branch;
import com.rishi.bank.respository.BranchRepository;

@Service
public class BranchService {

    @Autowired
    BranchRepository branchRepository;

    public List<Branch> findallbrnch()
    {
        return branchRepository.findAll();
    }

    public List<Branch> findallbranchbyBnkCode(String bnkcode)
    {
        List<Branch> allbranch=new ArrayList<>();
        allbranch=branchRepository.findAll();

        List<Branch> allbnkcodebranch=new ArrayList<>();

        for(Branch id : allbranch)
        {
            if (id.getBankCode()==bnkcode)
            {
                allbnkcodebranch.add(id);
            }
        }
        return allbnkcodebranch;
    }

    public void CreateBranch(Branch brnch)
    {
        branchRepository.save(brnch);
    }

    

}
