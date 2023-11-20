package com.spring.hibernate.cruddemo.dao;


import com.spring.hibernate.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

}
