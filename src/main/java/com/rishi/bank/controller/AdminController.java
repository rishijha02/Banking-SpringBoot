package com.rishi.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rishi.bank.exception.ResourceNotFoundException;
import com.rishi.bank.service.AdminService;
import com.rishi.bank.service.BankService;
import com.rishi.bank.service.CustomerService;

@Controller
public class AdminController {

    @Autowired
    BankService bankService;

    @Autowired
    AdminService adminService;

    @Autowired
    CustomerService customerService;

    @GetMapping("/admin/index")
    public String adminhome(Model model)
    {
        model.addAttribute("bankNames",bankService.findallbanks());
        return "admin-page";
    }

    @GetMapping("/admin/viewProfile")
    public ModelAndView adminviewprofile(@RequestParam MultiValueMap<String , String> paramMap)
    {
        ModelAndView mav = new ModelAndView("admin-dashBoard");

        mav.addObject("admins", adminService.findAdminByAdminId(paramMap.getFirst("adminId"))
        .orElseThrow(()-> new ResourceNotFoundException("Admin Not Found with Id "+ paramMap.getFirst("adminId"))));
        mav.addObject("bankNames", paramMap.getFirst("bankNames"));
        return mav;
    }

    @GetMapping("/admin/showAdminForm")
    public ModelAndView showadmindetails(@RequestParam MultiValueMap<String , String> paramMap)
    {
        ModelAndView mav = new ModelAndView("admin-details");
         mav.addObject("admins", adminService.findAdminByAdminId(paramMap.getFirst("adminId"))
        .orElseThrow(()-> new ResourceNotFoundException("Admin Not Found with Id "+ paramMap.getFirst("adminId"))));
      
        return mav;
    }

    @GetMapping("/admin/customers/list")
    public ModelAndView admincustomerlist(@RequestParam MultiValueMap<String , String> paramMap)
    {
        ModelAndView mav = new ModelAndView("admin-list-customers");

        mav.addObject("customers", customerService.findllCustomersbyBankName(paramMap.getFirst("bankNames")));
        

        return mav;
    }

    @GetMapping("/admin/branches/list")
    public ModelAndView adminshowbrancheslist(@RequestParam MultiValueMap<String , String> paramMap)
    {
        ModelAndView mav = new ModelAndView("list-branches");
        mav.addObject("branches", adminService.findBrnchByBnkName(paramMap.getFirst("bankNames")));
        return mav;
    }

    @GetMapping("/admin/employees/list")
    public ModelAndView adminshowemployeelist(@RequestParam MultiValueMap<String , String> paramMap)
    {
        ModelAndView mav = new ModelAndView("list-employees");
        mav.addObject("employees", adminService.findEmployeesByBankName(paramMap.getFirst("bankNames")));
        
        return mav;
    }

    @GetMapping("/admin/reversalRequests/list")
    public String adminshowreversalrequest()
    {
        return "list-reversalRequests";
    }

}
