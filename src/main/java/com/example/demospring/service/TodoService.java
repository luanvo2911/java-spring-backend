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

  public Todo getById(Integer id){
    return todoRepository.findByID(id);
  }

  public List<Todo> getTodoByUserID(Integer id, Integer page, Integer item_per_page){
    return todoRepository.findTodosByUserID(id, page, item_per_page);
  }

  public Integer getTodoTotalByUserID(Integer id){
    return todoRepository.findTodosTotalByUserID(id);
  }

  public void insertTodo(Todo todo){
    todoRepository.insertTodo(todo.user_id, todo.todo, todo.status);
  }

  public void updateTodo(Todo todo){
    todoRepository.updateTodo(todo.id, todo.todo, todo.status);
  }

  public int deleteTodoByID(Integer id){
    return todoRepository.deleteTodoByID(id);
  }

}
