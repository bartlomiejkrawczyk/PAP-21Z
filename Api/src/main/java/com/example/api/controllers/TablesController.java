package com.example.api.controllers;

import com.example.api.entities.Table;
import com.example.api.repositories.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tables")
@RestController
public class TablesController {
    private final TablesRepository repository;

    @Autowired
    public TablesController(TablesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public List<Table> findAll() {
        return (List<Table>) repository.findAll();
    }

    @PostMapping
    public Table saveTable(@RequestBody Table table) {
        return repository.save(table);
    }

    @PutMapping("/{id}")
    public Table updateTable(@RequestBody Table newTable, Long id) {
        return repository.findById(id)
                .map(table -> {
                    table.setName(newTable.getName());
                    return repository.save(table);
                })
                .orElseGet(() -> {
                    newTable.setId(id);
                    return repository.save(newTable);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
