package com.springboot.cruddemo.service;

import com.springboot.cruddemo.entity.Employee;

import java.util.List;

// Service interface defining methods for employee-related business logic
public interface EmployeeService {
    // Method to retrieve all employees

    public List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void delete(int theId);
}
