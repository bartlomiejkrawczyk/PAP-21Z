package com.example.api.controllers;

import com.example.api.entities.SpecialRequest;
import com.example.api.repositories.SpecialRequestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/specialRequests")
@RestController
public class SpecialRequestsController {
    private final SpecialRequestsRepository repository;

    @Autowired
    public SpecialRequestsController(SpecialRequestsRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieve all the special requests available in the database
     *
     * @return List of special requests
     */
    @GetMapping("/all")
    public List<SpecialRequest> findAll() {
        return (List<SpecialRequest>) repository.findAll();
    }

    /**
     * Save a special request in the database
     *
     * @param request SpecialRequest to save
     * @return SpecialRequest that was saved (new id has been generated)
     */
    @PostMapping
    public SpecialRequest saveSpecialRequest(@RequestBody SpecialRequest request) {
        return repository.save(request);
    }


    /**
     * Delete the special request of given id
     *
     * @param id id of the SpecialRequest that is to be deleted
     */
    @DeleteMapping("/{id}")
    public void deleteSpecialRequest(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
