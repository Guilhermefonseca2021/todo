package com.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todo.models.Todo;
import com.todo.services.TodoService;

public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping("/viewTodoList")
    public String viewAllTodoItems(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("list", todoService.getAllTodoItems());
        model.addAttribute("msg", message);
        return "ViewTodoList";
    }

    @PutMapping("/updatetodostatus/{id}")
    public String UpdateTodoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if(todoService.updateTodoStatus(id)) {
            redirectAttributes.addFlashAttribute("message", "update success!");
            return "redirect:/viewTodoList";
        }
        redirectAttributes.addFlashAttribute("message", "Updare failure!");
        return "redirect:/viewTodoList";
    }   

    @GetMapping("/addtodoitem")
    public String addTodoItem(Model model) {
        model.addAttribute("todo", new Todo());
        return "addtodoitem";
    }

    @PostMapping("/savetodoitem")
    public String saveTodoItem(Todo todo) {
        if(todoService.saveOrUpdateTodoItem(todo)) {

        }
        return "redirect:/addtodoitem";
    }
    // @PostMapping
    // public String editSaveTodoItem() {

    // }
}


