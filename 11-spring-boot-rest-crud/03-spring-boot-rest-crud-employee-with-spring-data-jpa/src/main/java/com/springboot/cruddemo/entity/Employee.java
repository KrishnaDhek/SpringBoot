
package com.springboot.cruddemo.entity;

import jakarta.persistence.*;

/**
 * The {@code Employee} class represents a JPA entity, indicating that instances
 * of this class are persistent and mapped to a corresponding database table.
 * This class is part of the object-relational mapping (ORM) used in JPA.
 */
@Entity
//// Specifies the name of the database table associated with this entity
@Table(name = "employee")
public class Employee {

    // Fields representing columns in the "employee" table
    @Id
//    Specifies the generation strategy for the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    //define constructor
    public Employee(){

    }
    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    //define getter and setter

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


    //define toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
