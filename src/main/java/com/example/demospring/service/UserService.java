package com.example.demospring.service;

import com.example.demospring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospring.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUser(){
    return userRepository.findAllUsers();
  }

  public User getUserByID(String id){
    return userRepository.findUserByID(id);
  }

  public boolean authentication(String username, String passw){
    return userRepository.login(username, passw).size() > 0;
  }

  public void insertUser(User user){
    userRepository.insertUser(user.id, user.username, user.email);
  }

  public int deleteUserByID(String id){
    return userRepository.deleteUserByID(id);
  }
}
