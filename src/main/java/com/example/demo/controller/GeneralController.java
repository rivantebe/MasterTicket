package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {
 @GetMapping
 public String home() {
    return "Welcome to the home page!";
}

}
