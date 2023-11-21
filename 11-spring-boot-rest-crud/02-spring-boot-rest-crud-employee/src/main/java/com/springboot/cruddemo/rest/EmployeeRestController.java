package com.springboot.cruddemo.rest;


import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //expose endpoint "/employees/{employeeId}"
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId ){
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee==null) {
            throw new RuntimeException("Employee not found -" + employeeId);
        }
        return theEmployee;
    }
}
