package com.example.springbootreactbackend.controller;

import com.example.springbootreactbackend.entity.Employee;
import com.example.springbootreactbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @CrossOrigin
    @GetMapping(value = "/getAllEmps")
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    @CrossOrigin
    @PostMapping(value = "/addEmp")
    public String addEmployee(@RequestBody Employee e){
        repository.save(e);
        System.out.println(e);
        return "Employee added successfully!";
    }
}
