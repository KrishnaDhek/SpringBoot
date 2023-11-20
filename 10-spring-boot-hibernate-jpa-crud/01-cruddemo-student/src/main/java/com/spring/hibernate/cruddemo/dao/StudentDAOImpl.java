package com.spring.hibernate.cruddemo.dao;

import com.spring.hibernate.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


//Serialized annotation for repository, supports component scanning, translates JDBC exception
@Repository
public class StudentDAOImpl implements StudentDAO{
    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection


    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    //Since we are performing an update
    @Transactional
    public void save(Student theStudent) {
        //save the student object to the database
        entityManager.persist(theStudent);
    }



}
