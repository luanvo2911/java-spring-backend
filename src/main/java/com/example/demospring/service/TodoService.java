package com.example.demospring.service;

import com.example.demospring.repository.TodoRepository;
import com.example.demospring.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {

  @Autowired
  private TodoRepository todoRepository;

  public List<Todo> getAllTodo(){
    return todoRepository.findAllTodos();
  }

  public List<Todo> getTodoByUserID(String id){
    return todoRepository.findTodosByUserID(id);
  }

  public void insertTodo(Todo todo){
    todoRepository.insertTodo(todo.id, todo.user_id, todo.todo, todo.status);
  }

  public void updateTodo(Todo todo){
    todoRepository.updateTodo(todo.id, todo.todo, todo.status);
  }

  public int deleteTodoByID(String id){
    return todoRepository.deleteTodoByID(id);
  }

}
