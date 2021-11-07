package com.example.api.controllers;

import com.example.api.entities.DishExtraInformation;
import com.example.api.repositories.DishExtraInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/dish_extra_information")
@RestController
public class DishExtraInformationController {
    private final DishExtraInformationRepository repository;

    @Autowired
    public DishExtraInformationController(DishExtraInformationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("all")
    public List<DishExtraInformation> findAll() {
        return (List<DishExtraInformation>) repository.findAll();
    }
}
