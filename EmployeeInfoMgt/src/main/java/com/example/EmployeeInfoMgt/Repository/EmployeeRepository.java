package com.example.EmployeeInfoMgt.Repository;

import com.example.EmployeeInfoMgt.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContainingIgnoreCase(String name);
    List<Employee> findByPhoneContaining(String phone);
    List<Employee> findByEmailContainingIgnoreCase(String email);
}
