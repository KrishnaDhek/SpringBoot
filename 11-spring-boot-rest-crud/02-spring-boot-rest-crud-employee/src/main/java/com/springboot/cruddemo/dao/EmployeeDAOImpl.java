package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee " , Employee.class);

        //execute query and get result list
        List<Employee> theEmployee = theQuery.getResultList();

        //return the results
        return theEmployee;
    }


    @Override
    public Employee findById(int theId) {
        //Get employee by id:primary key
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //Return the employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save employee, if id=0 it will save as new entity else it will update
        Employee dbEmployee = entityManager.merge(theEmployee);
        //return the employee
        return dbEmployee;
    }

    @Override
    public void delete(int theId) {

        //find employee by id
        Employee theEmployee = entityManager.find(Employee.class, theId );

        //remove the employee
        entityManager.remove(theEmployee);
    }
}
