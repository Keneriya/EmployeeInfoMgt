package com.example.EmployeeInfoMgt.Service;

import com.example.EmployeeInfoMgt.Entity.Employee;
import com.example.EmployeeInfoMgt.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findById(Long id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public List<Employee> searchByName(String name){
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Employee> searchByEmail(String email){
        return employeeRepository.findByEmailContainingIgnoreCase(email);
    }

    public List<Employee> SearchByPhone(String phone){
        return employeeRepository.findByPhoneContaining(phone);
    }
}
