package com.todo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repositories.TodoRepository;
import com.todo.models.Todo;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getAllTodoItems() {
        List<Todo> todoList = new ArrayList<>();
        todoRepository.findAll().forEach(todo -> todoList.add(todo));
        return todoList;
    }

    public Todo getTodoItemById(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        return todoOptional.orElse(null);
    }

    public boolean updateTodoStatus(Long id) {
        Todo todo = getTodoItemById(id);
        if (todo != null) {
            todo.setStatus("completed");
            return saveOrUpdateTodoItem(todo);
        }
        return false;
    }

    public boolean saveOrUpdateTodoItem(Todo todo) {
        if (todo != null) {
            todoRepository.save(todo);
            return true;
        }
        return false;
    }

    public boolean deleteTodoItem(Long id) {
        if (getTodoItemById(id) != null) {
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
