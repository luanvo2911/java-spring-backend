package com.example.demospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DefaultController {

  @GetMapping("/")
    public String homepage() {
        return "Hello, this is homepage";
    }
  
  
}
