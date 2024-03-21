package com.example.demospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demospring.model.Todo;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, String> {
  
  @Query(value = "SELECT todos.id, users.id AS user_id, username, email, todo, status FROM users, todos \n" + //
        "WHERE users.id = todos.user_id ", nativeQuery = true)
  List<Todo>findAllTodos();

  @Query(value = "SELECT todos.id, users.id AS user_id, username, email, todo, status FROM users, todos \n" + //
        "WHERE users.id = todos.user_id and users.id = :id", nativeQuery = true)
  List<Todo>findTodosByUserID(@Param("id") String id);

  @Modifying
  @Transactional
  @Query(value = "INSERT INTO todos(id, user_id, todo, status) VALUES (:id, :user_id, :todo, :status)", nativeQuery = true)
  int insertTodo(String id, String user_id, String todo, String status);


  @Modifying
  @Transactional
  @Query(value = "UPDATE todos SET todo = :todo, status = :status WHERE todos.id = :id", nativeQuery = true)
  int updateTodo(String id, String todo, String status);


  @Modifying
  @Transactional
  @Query(value = "DELETE FROM todos WHERE todos.id = :id", nativeQuery = true)
  int deleteTodoByID(@Param("id") String id);

}
