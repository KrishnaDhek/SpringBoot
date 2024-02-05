package com.programming.springbootmongodb.service;

import com.programming.springbootmongodb.model.Expense;
import com.programming.springbootmongodb.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing expenses.
 */
@Service
public class ExpenseService {
    /**
     * Constructor to inject ExpenseRepository dependency.
     *
     * @param expenseRepository The repository for managing Expense entities.
     */

    public final ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    /**
     * Added a new expense
     *
     * @param expense The expense to be added.
     * */
    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }

    /**
     * Update an existing expense
     *
     * @param expense The expense to be updated
     * */
    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(()->new RuntimeException(String.format("Cannot Find Expense by Id %s",expense.getId())));


        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(savedExpense);

    }
    /**
     * Retrieves a list of all expenses
     *
     * @return  A list of all expenses*/


    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }


    /**
     * Retrieves an expense by its name
     *
     * @name name The name of expense to be retrieved
     * @return  return The expense with the specified name
     * @throws RuntimeException if the expense is not found
     * */
    public Expense getExpense(String name) {
        return expenseRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by Name - %s", name)));
    }

    /**
     * Delete an expense by its id
     *
     * @param id The id of the expense to be deleted
     * */
    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }

}
