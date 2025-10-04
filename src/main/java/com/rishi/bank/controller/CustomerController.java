package com.rishi.bank.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rishi.bank.exception.ResourceNotFoundException;
import com.rishi.bank.service.AccountService;
import com.rishi.bank.service.BankService;
import com.rishi.bank.service.BranchService;
import com.rishi.bank.service.CustomerService;
import com.rishi.bank.service.TransactionService;

@Controller
public class CustomerController {

    @Autowired
    BankService bankService;

    @Autowired
    CustomerService customerService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    AccountService accountService;

    @Autowired
    BranchService branchService;

    @GetMapping("/customer/index")
    public String customerhome(Model model)
    {
        model.addAttribute("bankNames", bankService.findallbanks());
        return "customer-page";
    }

    @GetMapping("/customer/viewProfile")
    public ModelAndView customerviewprofile( @RequestParam MultiValueMap<String , String> paramMap)
    {
       ModelAndView mav = new ModelAndView("customer-dashBoard");
       mav.addObject("customers", customerService.findByCustomerId(paramMap.getFirst("customerId"))
       .orElseThrow(()-> new ResourceNotFoundException("customer not found with id "+paramMap.getFirst("customerId"))));
       mav.addObject("bankNames", paramMap.getFirst("bankNames"));
       mav.addObject("accountNo", paramMap.getFirst("accountNo"));
        return mav;
    }

    @GetMapping("/customer/transactions/list")
    public ModelAndView showcustomertransactions(@RequestParam MultiValueMap<String , String> paramMap)
    {
        ModelAndView mav = new ModelAndView("customer-transactions");
       mav.addObject("transactions", transactionService.findAllTrnsctnByAccNum(paramMap.getFirst("accountNo")));
       
        return mav;
    }



    @GetMapping("/customer/depositForm")
    public String depositform()
    {
        return "customer-deposit";
    }

    @PostMapping("/customer/saveDeposit")
	public ModelAndView saveDeposit(@RequestParam MultiValueMap<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("deposit-display");
		accountService.AddBalance(new BigDecimal(paramMap.getFirst("amount")),(paramMap.getFirst("accountNumber")));
//		if(bankAccountService.deposit(Double.parseDouble(paramMap.getFirst("amount")),Integer.parseInt(paramMap.getFirst("accountNumber"))))
//		{
//			mav.addObject("value",true);
//		}
		mav.addObject("accountNumber",paramMap.getFirst("accountNumber"));
		mav.addObject("name",paramMap.getFirst("name"));
		return mav;
	}

    @GetMapping("/customer/withDrawForm")
    public String withdrawform()
    {
        return "customer-withDraw";
    }


    @PostMapping("/customer/savewithDraw")
	public ModelAndView savewithDraw(@RequestParam MultiValueMap<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("withDraw-display");
		accountService.RemoveBalance(new BigDecimal(paramMap.getFirst("amount")),(paramMap.getFirst("accountNumber")));
//		if(bankAccountService.deposit(Double.parseDouble(paramMap.getFirst("amount")),Integer.parseInt(paramMap.getFirst("accountNumber"))))
//		{
//			mav.addObject("value",true);
//		}
		mav.addObject("accountNumber",paramMap.getFirst("accountNumber"));
		mav.addObject("name",paramMap.getFirst("name"));
		return mav;
	}

    @GetMapping("/customer/onboard")
    public String customeronboard(Model model)
    {
        model.addAttribute("BranchCodes", branchService.findallbrnch());
        return "customer-onboard";
    }

     @PostMapping("/customer/newOnboard")
	public ModelAndView CustomerNewOnboard(@RequestParam MultiValueMap<String, String> paramMap) {
		ModelAndView mav = new ModelAndView("customer-onboard");
		accountService.customeronboard((paramMap.getFirst("CustomerId")),
        (paramMap.getFirst("accountNumber")),
        (paramMap.getFirst("name")),
        new BigDecimal(paramMap.getFirst("amount")),
        (paramMap.getFirst("branchCode")));
//		if(bankAccountService.deposit(Double.parseDouble(paramMap.getFirst("amount")),Integer.parseInt(paramMap.getFirst("accountNumber"))))
//		{
//			mav.addObject("value",true);
//		}
		//mav.addObject("accountNumber",paramMap.getFirst("accountNumber"));
		//mav.addObject("name",paramMap.getFirst("name"));
		return mav;
	}

    @GetMapping("/customer/showCustomerForm")
	public ModelAndView showEmployeeDetails(@RequestParam String customerId) {
		ModelAndView mav = new ModelAndView("customer-details");
		mav.addObject("customers",customerService.findByCustomerId(customerId)
        .orElseThrow(() -> new ResourceNotFoundException("customer not found with id " +customerId)));
		return mav;
	}

}
