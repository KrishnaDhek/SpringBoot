package com.programming.springbootmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

// MongoDB Document annotation indicating that instances of this class will be stored in a
// collection named "expense"

@Document("expense")
public class Expense {
    // MongoDB's annotation indicating that this field serves as the primary key in the collection
    @Id
    private String id;

    // MongoDB's annotation specifying the field name in the document and enforcing uniqueness
    @Field(name = "name")
    @Indexed(unique = true)
    private String expenseName;

    // Enumeration representing different categories of expenses
    @Field(name = "category")
    private ExpenseCategory expenseCategory;

    // BigDecimal field to store the amount of the expense
    @Field(name = "amount")
    private BigDecimal expenseAmount;

    // Constructor to initialize the Expense object
    public Expense(String id, String expenseName, ExpenseCategory expenseCategory, BigDecimal expenseAmount) {
        this.id = id;
        this.expenseName = expenseName;
        this.expenseCategory = expenseCategory;
        this.expenseAmount = expenseAmount;
    }

    //Getter and Setter method for retrieving the expense
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(BigDecimal expenseAmount) {
        this.expenseAmount = expenseAmount;
    }
}
