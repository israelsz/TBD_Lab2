package com.example.Lab1TBD.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {
    @GetMapping("/")
    public String HelloWorld(){
        return "Hello World";
    }
}

