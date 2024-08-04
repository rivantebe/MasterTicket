package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneralController {
	@Autowired
	
	@GetMapping("/healthcheck")
	public String healthcheck() {
		return "OK";
	}
}
