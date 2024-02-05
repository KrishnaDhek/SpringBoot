package com.programming.springbootmongodb.controller;

import com.programming.springbootmongodb.model.Expense;
import com.programming.springbootmongodb.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    /**
     * ExpenseController Constructor
     *
     * This constructor initializes the ExpenseController with an instance of ExpenseService.
     * The ExpenseService is injected to facilitate communication between the controller
     * and the underlying service layer for managing expense-related operations.
     *
     * @param expenseService The ExpenseService responsible for handling business logic and data operations.
     */
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    //Endpoint to add a new expense
    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense){
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    //Endpoint to update an existing expense
    @PutMapping
    public ResponseEntity<Void> updateExpense(@RequestBody Expense expense){
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();

    }

    //Endpoint to retrieve all the expenses
    @GetMapping
    public ResponseEntity<List<Expense>>getAllExpense(){
        return ResponseEntity.ok(expenseService.getAllExpense());
    }

    //Endpoint to retrieve an expense by name
    @GetMapping("/{name}")
    public ResponseEntity getExpenseByName(@PathVariable String name){

        return ResponseEntity.ok(expenseService.getExpense(name));
    }


    //Endpoint to delete an expense by ID
    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable  String id){
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
