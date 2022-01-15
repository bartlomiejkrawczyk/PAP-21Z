package com.example.api.controllers;

import com.example.api.entities.EmployeeKind;
import com.example.api.repositories.EmployeeKindsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/employeeKinds")
@RestController
public class EmployeeKindsController {
    private final EmployeeKindsRepository repository;

    @Autowired
    public EmployeeKindsController(EmployeeKindsRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieve all employee kinds available in the database with employees assigned to those positions
     *
     * @return List of employee kinds
     */
    @GetMapping("all")
    public List<EmployeeKind> findAll() {
        return (List<EmployeeKind>) repository.findAll();
    }

}
