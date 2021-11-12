package com.example.api.controllers;

import com.example.api.entities.Employee;
import com.example.api.repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeesController {
    private final EmployeesRepository repository;

    @Autowired
    public EmployeesController(EmployeesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll();
    }

    @GetMapping("/kind/{kind}")
    public List<Employee> findEmployeesOfKind(@PathVariable Long kind) {
        return repository.findEmployeesByEmployeeKindId(kind);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setEmployeeKindId(newEmployee.getEmployeeKindId());
                    employee.setFamilyName(newEmployee.getFamilyName());
                    employee.setFirstName(newEmployee.getFirstName());
                    return repository.save(employee);
                }).orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
