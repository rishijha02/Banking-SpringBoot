package com.rishi.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishi.bank.model.Address;
import com.rishi.bank.service.AddressService;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/address")
    public List<Address> findalladdress()
    {
       return addressService.findalladdress();
    }

    @PostMapping("/address/createadd")
    public List<Address> createaddress(Address add)
    {
        addressService.createaddress(add);
        return addressService.findalladdress();
    }
}
