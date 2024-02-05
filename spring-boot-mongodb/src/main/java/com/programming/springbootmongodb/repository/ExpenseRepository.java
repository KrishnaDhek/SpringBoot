package com.programming.springbootmongodb.repository;

import com.programming.springbootmongodb.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense,String > {
    /**
     * Custom query method to find an expense by its name.
     *
     * @param name The name of the expense to search for.
     * @return An optional containing the expense if found, or empty if not.
     */
    @Query("{'name': ?0}")
    Optional<Expense> findByName(String name);


}
