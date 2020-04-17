package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;



    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void updateEmployee(long id, Employee employee) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            //employee.setId(employee.getId());
            employeeRepository.save(employee);
        } else throw new ValidationException();
    }

    @Override
    public void deleteEmployee(long id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else throw new ValidationException();
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
           return employeeRepository.findById(id);


    }



    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> findEmployeeByNameAndAge(String name, int age) {
        return employeeRepository.findByNameAndAgeGreaterThan(name,age);
    }
}
