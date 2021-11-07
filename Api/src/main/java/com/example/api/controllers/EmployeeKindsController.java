package com.example.api.controllers;

import com.example.api.entities.EmployeeKind;
import com.example.api.repositories.EmployeeKindsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/employee_kinds")
public class EmployeeKindsController {
    private final EmployeeKindsRepository repository;

    @Autowired
    public EmployeeKindsController(EmployeeKindsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public List<EmployeeKind> findAll() {
        return (List<EmployeeKind>) repository.findAll();
    }
}
