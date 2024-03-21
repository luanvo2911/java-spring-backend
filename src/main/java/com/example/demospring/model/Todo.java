package com.example.demospring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
@SecondaryTable(name = "users", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class Todo {

  public Todo(){}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", table = "todos")
  public String id;

  @Column(name = "username", table = "users")
  public String username;

  @Column(name = "email", table = "users")
  public String email;

  @Column(name = "user_id", table = "users")
  public String user_id;

  @Column(name = "todo", table = "todos")
  public String todo;

  @Column(name = "status", table = "todos")
  public String status;


}
