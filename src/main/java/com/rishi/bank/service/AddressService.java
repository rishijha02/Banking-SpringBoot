package com.rishi.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RestController;

import com.rishi.bank.model.Address;
import com.rishi.bank.respository.AddressRepository;

@Service
public class AddressService {

@Autowired
AddressRepository addressRepository;

    public List<Address> findalladdress()
    {
       return addressRepository.findAll();
    }

    public void createaddress(Address add)
    {
        addressRepository.save(add);
    }

}
