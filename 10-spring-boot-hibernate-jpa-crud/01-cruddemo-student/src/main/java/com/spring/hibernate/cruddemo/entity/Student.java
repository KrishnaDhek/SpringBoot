package com.spring.hibernate.cruddemo.entity;

import jakarta.persistence.*;

@Entity
//Mapping with the database
@Table(name = "student")
public class Student {


    //define fields
    @Id
    //assigning primary key value using database identify column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //specifying column name as per the database column name
    @Column(name = "id")
    private int id;

    //specifying column name as per the database column name
    @Column(name = "first_name")
    private String firstName;

    //specifying column name as per the database column name
    @Column(name = "last_name")
    private String lastName;

    //specifying column name as per the database column name
    @Column(name = "email")
    private String email;


    //define constructor
    public Student(){
        //default constructor for JPA

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    //define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //define toString() method


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
