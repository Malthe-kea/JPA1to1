package com.example.jpa1to1.repository;

import com.example.jpa1to1.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
    List<Employee> findEmployeeByName(String name);
}
