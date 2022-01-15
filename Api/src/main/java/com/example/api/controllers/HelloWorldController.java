package com.example.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HelloWorldController {

    /**
     * Hello, World!
     * Method mapped by /
     *
     * @return String with hello world text
     */
    @GetMapping
    public String helloWorld() {
        return "Hello, World!";
    }
}
