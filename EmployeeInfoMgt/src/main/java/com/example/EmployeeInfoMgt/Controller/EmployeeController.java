package com.example.EmployeeInfoMgt.Controller;

import com.example.EmployeeInfoMgt.Entity.Address;
import com.example.EmployeeInfoMgt.Entity.Employee;
import com.example.EmployeeInfoMgt.Service.AddressService;
import com.example.EmployeeInfoMgt.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressService addressService;

    //Resgister new employee
    @PostMapping("/create")
    public Employee register(@RequestBody Employee employee) {
        Address savedAddress = addressService.save(employee.getAddress());
        employee.setAddress(savedAddress);
        return employeeService.save(employee);
    }



    // Update existing employee
    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return employeeService.findById(id).map(emp -> {
            emp.setName(updatedEmployee.getName());
            emp.setEmail(updatedEmployee.getEmail());
            emp.setPhone(updatedEmployee.getPhone());

            Address savedAddress = addressService.save(updatedEmployee.getAddress());
            emp.setAddress(savedAddress);

            return employeeService.save(emp);
        }).orElse(null);
    }

    // View all employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    // Search employee
    @GetMapping("/search")
    public List<Employee> search(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) String phone,
                                 @RequestParam(required = false) String email) {
        if (name != null && !name.isEmpty()) {
            return employeeService.searchByName(name);
        } else if (phone != null && !phone.isEmpty()) {
            return employeeService.searchByPhone(phone);
        } else if (email != null && !email.isEmpty()) {
            return employeeService.searchByEmail(email);
        } else {
            return List.of(); // or return all employees, based on your preference
        }
    }

}
