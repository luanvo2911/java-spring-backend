package com.example.demospring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  public User() {
  }

  public User(String id, String username, String email) {
    this.id = id;
    this.username = username;
    this.email = email;
  }

  @Id
  public String id;
  public String username;
  public String email;

}
