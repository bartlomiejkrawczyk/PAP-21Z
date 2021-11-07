package com.example.api.controllers;

import com.example.api.entities.Employee;
import com.example.api.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeesController {
    private final EmployeesRepository repository;

    @Autowired
    public EmployeesController(EmployeesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll();
    }
}
