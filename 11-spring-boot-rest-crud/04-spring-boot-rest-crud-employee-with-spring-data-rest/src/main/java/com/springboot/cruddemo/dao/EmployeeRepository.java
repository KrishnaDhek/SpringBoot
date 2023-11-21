package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The EmployeeRepository interface extends JpaRepository for the Employee entity.
 * It leverages Spring Data JPA's generic CRUD operations, eliminating the need for explicit implementations.
 * The interface is parameterized with the Employee entity and the type of its primary key (Integer).
 */

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //no need to write any code
}
