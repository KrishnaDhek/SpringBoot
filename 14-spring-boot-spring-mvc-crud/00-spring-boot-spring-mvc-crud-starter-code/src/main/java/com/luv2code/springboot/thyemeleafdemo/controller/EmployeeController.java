package com.luv2code.springboot.thyemeleafdemo.controller;

import com.luv2code.springboot.thyemeleafdemo.entity.Employee;
import com.luv2code.springboot.thyemeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    private EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //add mapping for listing employees
    @GetMapping("/list")
    private String listEmployees(Model themodel){

        //get the employee from database
        List<Employee> theEmployees = employeeService.findAll();

        //add employee to spring model;
        themodel.addAttribute("employees", theEmployees);

        return "employees/list-employee";


    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Employee theEmployee =  new Employee();

        theModel.addAttribute("employee" ,theEmployee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        //save the employee
        employeeService.save(theEmployee);

        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";

    }
}
