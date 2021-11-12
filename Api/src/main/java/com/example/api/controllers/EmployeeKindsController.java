package com.example.api.controllers;

import com.example.api.entities.EmployeeKind;
import com.example.api.repositories.EmployeeKindsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employeeKinds")
@RestController
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

    @PostMapping
    public EmployeeKind saveEmployeeKind(@RequestBody EmployeeKind employeeKind) {
        return repository.save(employeeKind);
    }

    @PutMapping("/{id}")
    public EmployeeKind updateEmployeeKind(@RequestBody EmployeeKind newEmployeeKind, @PathVariable Long id) {
        return repository.findById(id)
                .map(employeeKind -> {
                    employeeKind.setName(newEmployeeKind.getName());
                    return repository.save(employeeKind);
                }).orElseGet(() -> {
                    newEmployeeKind.setId(id);
                    return repository.save(newEmployeeKind);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeKind(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
