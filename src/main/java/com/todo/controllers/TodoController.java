package com.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.todo.services.TodoService;

public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping
    public String viewAllTodoItems() {

    }
    @PutMapping
    public String UpdateTodoStatus() {

    }   
    @PostMapping
    public String addTodo() {

    }
    @PostMapping
    public String saveTodoItem() {

    }
    @PostMapping
    public String editSaveTodoItem() {

    }
}


