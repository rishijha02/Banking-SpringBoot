package com.rishi.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer srno;

    String AptNum;
    public Address() {
    }
    String Street;
    String City;
    String State;
    String Country;
    public Address(String aptNum, String street, String city, String state, String country) {
        AptNum = aptNum;
        Street = street;
        City = city;
        State = state;
        Country = country;
    }
    public Integer getSrno() {
        return srno;
    }
    public void setSrno(Integer srno) {
        this.srno = srno;
    }
    public String getAptNum() {
        return AptNum;
    }
    public void setAptNum(String aptNum) {
        AptNum = aptNum;
    }
    public String getStreet() {
        return Street;
    }
    public void setStreet(String street) {
        Street = street;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {
        City = city;
    }
    public String getState() {
        return State;
    }
    public void setState(String state) {
        State = state;
    }
    public String getCountry() {
        return Country;
    }
    public void setCountry(String country) {
        Country = country;
    }

}
