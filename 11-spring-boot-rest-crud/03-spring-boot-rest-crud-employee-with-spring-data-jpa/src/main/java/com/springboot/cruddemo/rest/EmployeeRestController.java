package com.springboot.cruddemo.rest;


import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.exception.EmployeeInvalidException;
import com.springboot.cruddemo.exception.EmployeeNotFoundException;
import com.springboot.cruddemo.service.EmployeeService;
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

    //`findAll`: Handles GET requests for retrieving all employees.
    @GetMapping("/employees")
    public List<Employee> findAll(){
       return employeeService.findAll();
    }

    //getEmployee`: Handles GET requests for retrieving a specific employee by ID.
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId )  {
        try {
            int id = Integer.parseInt(employeeId);
          Employee theEmployee = employeeService.findById(id);
          if(theEmployee==null){
              throw new EmployeeNotFoundException("Employee not found "+id);
          }
          return theEmployee;
        }
        catch (NumberFormatException e){
            throw new EmployeeInvalidException("Invalid employee id "+employeeId,e);
        }

    }


    // addEmployee`: Handles POST requests for adding a new employee.
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // Setting ID to 0 to ensure it's treated as a new employee
        theEmployee.setId(0);

        // Saving the new employee using the service
        Employee dbEmployee = employeeService.save(theEmployee);

        // Returning the saved employee with its assigned ID
        return dbEmployee;
    }

    //`updateEmployee`: Handles PUT requests for updating an existing employee.
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // Handles DELETE requests to delete an employee by ID
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        // Finding the employee by ID using the EmployeeService
        Employee theEmployee = employeeService.findById(employeeId);

        // If the employee is not found, throw an exception with a 404 status
        if(theEmployee==null){
                throw new EmployeeNotFoundException("Employee not found "+employeeId);
            }

        // Deleting the employee by ID using the service
        employeeService.deleteById(employeeId);
            return "Deleted Employee id "+employeeId;

    }
}
