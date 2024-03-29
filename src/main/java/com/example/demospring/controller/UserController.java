package com.example.demospring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demospring.service.UserService;
import com.example.demospring.model.User;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
    public List<User> getUser(){
      return userService.getAllUser();
    }

  @GetMapping("/{id}")
    public User getUserByID(@PathVariable String id){
      return userService.getUserByID(id);
    }

  @PostMapping
    public void insertUser(@RequestBody User user){
      userService.insertUser(user);
    }

  @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable String id){
      int rowDeleted = userService.deleteUserByID(id);
      return "There are " + rowDeleted + " deleted!";
    }  
}
