package com.todo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositories.TodoRepository;
import com.todo.models.Todo;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getAllTodoItems() {
        ArrayList<Todo> todoList = new ArrayList<>();
        todoRepository.findAll().forEach(todo -> todoList.add(todo));
        return todoList;
    }

    // public Todo getTodoItemById(Long id) {
        
    // }
    
    // public updateTodoStatus() {
    //     return todoRepository.
    // }

    // public saveTodoItem() {}
    // public deleteTodoItem() {}
}
