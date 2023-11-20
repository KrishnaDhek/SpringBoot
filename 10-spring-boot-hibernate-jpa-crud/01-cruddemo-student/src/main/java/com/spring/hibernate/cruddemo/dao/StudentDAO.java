package com.spring.hibernate.cruddemo.dao;


import com.spring.hibernate.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

}
