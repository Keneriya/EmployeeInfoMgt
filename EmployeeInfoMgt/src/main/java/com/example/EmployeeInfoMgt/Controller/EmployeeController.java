package com.example.EmployeeInfoMgt.Controller;

import com.example.EmployeeInfoMgt.Entity.Employee;
import com.example.EmployeeInfoMgt.Service.AddressService;
import com.example.EmployeeInfoMgt.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressService addressService;

    //Resgister new employee
    @PostMapping
    public Employee register(@RequestBody Employee employee){
        Address savedAddress = addressService.save(employee.getAddress());
        employee.setAddress(savedAddress);
        return employeeService.save(employee);
    }
}
