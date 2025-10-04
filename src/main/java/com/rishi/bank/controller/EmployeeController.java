package com.rishi.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rishi.bank.exception.ResourceNotFoundException;
import com.rishi.bank.service.AccountService;
import com.rishi.bank.service.BankService;
import com.rishi.bank.service.BranchService;
import com.rishi.bank.service.CustomerService;
import com.rishi.bank.service.EmployeeService;
import com.rishi.bank.service.TransactionService;

@Controller
public class EmployeeController {

    @Autowired
    BankService bankService;

    @Autowired
    BranchService branchService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountService accountService;

     @GetMapping("/employee/index")
    public String employeehome(Model model)
    {
        model.addAttribute("bankNames", bankService.findallbanks());
        model.addAttribute("branches", branchService.findallbrnch());

        return "employee-page";
    }

    @GetMapping("/employee/viewProfile")
    public ModelAndView employeeviewprofile( @RequestParam MultiValueMap<String , String> paramMap)
    {
       ModelAndView mav = new ModelAndView("employee-dashBoard");
       mav.addObject("employees", employeeService.findByEmpId(paramMap.getFirst("employeeId"))
       .orElseThrow(() -> new ResourceNotFoundException("Employee Not found")));
       mav.addObject("bankNames", paramMap.getFirst("bankNames"));
       mav.addObject("branchCode", paramMap.getFirst("branches"));
        return mav;
    }

    @GetMapping("/employee/customers/list")
    public ModelAndView AllCustomerListByBank( @RequestParam MultiValueMap<String , String> paramMap)
    {
       ModelAndView mav = new ModelAndView("list-customers");
       mav.addObject("customers", customerService.findllCustomersbyBankName(paramMap.getFirst("bankNames")));
        return mav;
    }


    @GetMapping("/employee/transactions/list")
    public ModelAndView AllTransactionsBybranch( @RequestParam MultiValueMap<String , String> paramMap)
    {
       ModelAndView mav = new ModelAndView("list-transactions");
       mav.addObject("transactions", transactionService.findAllTransactionBybrnchCode(paramMap.getFirst("branchCode")));
        return mav;
    }

     @GetMapping("/employee/bankAccounts/list")
    public ModelAndView AllAccountsBybranch( @RequestParam MultiValueMap<String , String> paramMap)
    {
       ModelAndView mav = new ModelAndView("list-bankAccounts");
       mav.addObject("bankAccounts", accountService.findAllAccountByBranch(paramMap.getFirst("branchCode")));
        return mav;
    }

    
    @GetMapping("/employee/showEmployeeForm")
    public ModelAndView employeeByEmpId( @RequestParam String employeeId)
    {
       ModelAndView mav = new ModelAndView("employee-details");
       mav.addObject("employees", employeeService.findByEmpId(employeeId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with Employee Id "+ employeeId)));
        return mav;
    }

}
