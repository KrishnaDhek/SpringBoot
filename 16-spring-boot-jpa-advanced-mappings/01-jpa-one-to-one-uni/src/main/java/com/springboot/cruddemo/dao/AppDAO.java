package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);



}
