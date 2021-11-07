package com.example.api.controllers;

import com.example.api.entities.Table;
import com.example.api.repositories.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/tables")
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
}
