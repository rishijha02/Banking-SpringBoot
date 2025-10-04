package com.rishi.bank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer empnum;

    String empName;

    String employeeId;
    String brnchCode;

    public Integer getEmpnum() {
        return empnum;
    }

    public Employee(Integer empnum, String empName, String employeeId) {
        this.empnum = empnum;
        this.empName = empName;
        this.employeeId = employeeId;
    }

    public Employee() {
    }

    public void setEmpnum(Integer empnum) {
        this.empnum = empnum;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    



}
