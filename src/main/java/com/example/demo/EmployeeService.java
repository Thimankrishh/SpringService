package com.example.demo;


import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {

    void addEmployee(Employee employee);
    void updateEmployee(long id, Employee employee);
    void deleteEmployee(long id);
    Optional<Employee> getEmployeeById(long id);
    List<Employee> getAllEmployees();
    List<Employee> findEmployeeByName(String name);
    List<Employee> findEmployeeByNameAndAge(String name, int age);
}
