package com.example.EmployeeInfoMgt.Controller;

import com.example.EmployeeInfoMgt.Entity.Address;
import com.example.EmployeeInfoMgt.Entity.Employee;
import com.example.EmployeeInfoMgt.Service.AddressService;
import com.example.EmployeeInfoMgt.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    // View all employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



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

    /*
    // Search employee

*/
}
