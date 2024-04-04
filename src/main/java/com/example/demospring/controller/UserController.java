package com.example.demospring.controller;

// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demospring.service.UserService;
import com.example.demospring.model.Auth;
import com.example.demospring.model.User;

import java.util.List;

@RestController
// @CrossOrigin
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

  @PostMapping("/login")
  public Boolean authentication(@RequestBody Auth auth) {
      return userService.authentication(auth.username, auth.passw);
  }
  

  @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable String id){
      userService.deleteUserByID(id);
    }  
}
