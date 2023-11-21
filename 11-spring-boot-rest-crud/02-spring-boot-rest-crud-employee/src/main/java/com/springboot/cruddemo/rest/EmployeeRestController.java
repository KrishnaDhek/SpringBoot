package com.springboot.cruddemo.rest;


import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

   private EmployeeService employeeService;

    //inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //expose endpoint "/employees" and return the list of employee
    @GetMapping("/employees")
    public List<Employee> findAll(){
       return employeeService.findAll();
    }

    //add mapping for getting  employee via id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId ){

        // Retrieve the employee from the service by ID
        Employee theEmployee = employeeService.findById(employeeId);

        // If the employee is not found, throw a runtime exception
        if(theEmployee==null) {
            throw new RuntimeException("Employee not found -" + employeeId);
        }
        return theEmployee;
    }

    // Adding mapping to handle POST requests to add a new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // Setting ID to 0 to ensure it's treated as a new employee
        theEmployee.setId(0);

        // Saving the new employee using the service
        Employee dbEmployee = employeeService.save(theEmployee);

        // Returning the saved employee with its assigned ID
        return dbEmployee;
    }
}
