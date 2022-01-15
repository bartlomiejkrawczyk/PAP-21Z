package com.example.api.controllers;

import com.example.api.entities.Employee;
import com.example.api.projections.EmployeeNamesOnly;
import com.example.api.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * Retrieve all employees from the database
     *
     * @return List of all the employees
     */
    @GetMapping("/all")
    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll();
    }

    /**
     * Retrieve information on all the employees of given kind
     *
     * @param employeeKindId id of employee position
     * @return List of employees' information
     */
    @GetMapping("/names/{employeeKindId}")
    public List<EmployeeNamesOnly> findNamesByEmployeeKindId(@PathVariable Long employeeKindId) {
        return repository.findNamesUsingEmployeeKind(employeeKindId);
    }

    /**
     * Retrieve all employees of given kind from the database
     *
     * @param kind id of employee position
     * @return List of all the employees on given position
     */
    @GetMapping("/kind/{kind}")
    public List<Employee> findEmployeesOfKind(@PathVariable Long kind) {
        return repository.findEmployeesByEmployeeKindId(kind);
    }

}
