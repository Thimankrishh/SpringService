package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

//@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

   List<Employee> findByName(String name);
   List<Employee> findByNameAndAgeGreaterThan(String name, int age);
    // deleteById(Long id);
}
