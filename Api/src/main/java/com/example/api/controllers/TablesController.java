package com.example.api.controllers;

import com.example.api.entities.Table;
import com.example.api.repositories.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/tables")
@RestController
public class TablesController {
    private final TablesRepository repository;

    @Autowired
    public TablesController(TablesRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieve all the tables available in the database
     *
     * @return List of all the tables
     */
    @GetMapping("all")
    public List<Table> findAll() {
        return (List<Table>) repository.findAll();
    }

}
