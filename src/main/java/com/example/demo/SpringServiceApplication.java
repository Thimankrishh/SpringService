package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringServiceApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(SpringServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository employeeRepository){
        return (args -> {
            employeeRepository.save(new Employee(1,"Kamal",24));
            employeeRepository.save(new Employee(2,"Saman", 26));

            // fetch all Employees
            log.info("Employees found with findAll():");
            log.info("-------------------------------");
            for (Employee Employee : employeeRepository.findAll()) {
                log.info(Employee.getName());
            }
            log.info("");
        });
    }

}
