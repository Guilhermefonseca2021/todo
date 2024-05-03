package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.todo.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}
