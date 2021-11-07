package com.example.api.controllers;

import com.example.api.entities.Receipt;
import com.example.api.repositories.ReceiptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/receipts")
@RestController
public class ReceiptsController {
    private final ReceiptsRepository repository;

    @Autowired
    public ReceiptsController(ReceiptsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public List<Receipt> findAll() {
        return (List<Receipt>) repository.findAll();
    }
}
