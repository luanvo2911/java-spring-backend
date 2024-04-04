package com.example.demospring.controller;

// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.demospring.model.Todo;
import com.example.demospring.service.TodoService;

import java.util.List;

@RestController
// @CrossOrigin
@RequestMapping ("/todos")
public class TodoController {

  @Autowired
  private TodoService todoService;

  @GetMapping
    public List<Todo> getTodo() {
        return todoService.getAllTodo();
    }

  @GetMapping(value = "/{id}")
    public Todo getTodoById(@PathVariable Integer id) {
      return todoService.getById(id);
    }
  
  @GetMapping(value = "/{user_id}/{page}/{item_per_page}")
    public List<Todo> getTodoByUserID(@PathVariable Integer user_id, @PathVariable Integer page, @PathVariable Integer item_per_page){
      return todoService.getTodoByUserID(user_id, page, item_per_page);
    }

  @GetMapping(value = "/{user_id}/total")
  public Integer getTodoTotalByUserID(@PathVariable Integer user_id){
    return todoService.getTodoTotalByUserID(user_id);
  }

  @PostMapping
    public void insertTodo(@RequestBody Todo todo){
      todoService.insertTodo(todo);
    }

  @PutMapping
  public void updateTodo(@RequestBody Todo todo){
    todoService.updateTodo(todo);
  }

  @DeleteMapping(value = "/{id}")
  @ResponseStatus(HttpStatus.OK)
    public void deleteTodoByID(@PathVariable Integer id){
      todoService.deleteTodoByID(id);
    }
}
