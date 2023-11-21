package com.springboot.cruddemo.service;


import com.springboot.cruddemo.dao.EmployeeRepository;
import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service class for handling employee-related business logic and interaction with the DAO layer.
 * The @Service annotation indicates that this class is a Spring service component.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    // DAO for accessing employee data
    private EmployeeRepository employeeRepository;

    // Constructor-based dependency injection

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }
    // Implementation of the findAll method from the EmployeeService interface
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee =null;
        if(result.isPresent()){
            theEmployee =result.get();
        }
        else {
            throw new RuntimeException("Did not find employee Id "+theId);
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }


    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }


}
