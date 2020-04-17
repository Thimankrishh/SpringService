package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeServiceController {

    @Autowired
    EmployeeService employeeService;



    @GetMapping(value = "/employees")
    public ResponseEntity<Object> getEmployeeList(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable("id") long id) {
        Optional<Employee> emp = employeeService.getEmployeeById(id);
        if(emp.isPresent()){
            return new ResponseEntity<>(emp, HttpStatus.OK);

        } else  return new ResponseEntity<>("Employee Not Found", HttpStatus.NOT_FOUND);


    }

    @PostMapping(value = "/employees")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        if (employee.getAge() == 0 || employee.getName() == null) {
            return new ResponseEntity<>("Employee data are missing", HttpStatus.BAD_REQUEST);
        } else {
            employeeService.addEmployee(employee);
            return new ResponseEntity<>("Employee is created successfully", HttpStatus.OK);
        }
    }

    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee) {
        if (employee.getAge() == 0 || employee.getName() == null) {
            return new ResponseEntity<>("Employee data are missing", HttpStatus.BAD_REQUEST);
        } else {
            try {
                employeeService.updateEmployee(id,employee);
                return new ResponseEntity<>("Employee is updated successfully", HttpStatus.OK);
            } catch (Exception e){
                return new ResponseEntity<>("No Such Employee", HttpStatus.BAD_REQUEST);
            }

        }
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") long id) {
        try {
            employeeService.deleteEmployee(id);
        } catch (Exception e){
            return new ResponseEntity<>("No Such Employee", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Employee is deleted successfully", HttpStatus.OK);
    }


    @GetMapping(value = "/employee/{name}")
    public ResponseEntity<Object> getEmployeeByName(@PathVariable("name") String name) {
        return new ResponseEntity<>( employeeService.findEmployeeByName(name), HttpStatus.OK);
    }


    @GetMapping(value = "/employee/{name}/{age}")
    public ResponseEntity<Object> getEmployeeByNameAndAge(@PathVariable("name") String name, @PathVariable("age") int age) {

        return new ResponseEntity<>( employeeService.findEmployeeByNameAndAge(name,age), HttpStatus.OK);
    }
}
