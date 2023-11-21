package com.springboot.cruddemo.service;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling employee-related business logic and interaction with the DAO layer.
 * The @Service annotation indicates that this class is a Spring service component.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    // DAO for accessing employee data

    private EmployeeDAO employeeDAO;

    // Constructor-based dependency injection

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }
    // Implementation of the findAll method from the EmployeeService interface
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
