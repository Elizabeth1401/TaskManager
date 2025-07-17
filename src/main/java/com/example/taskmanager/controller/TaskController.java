package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    //POST
    @PostMapping
    public Task createTask (@Valid @RequestBody Task task){
        return taskService.addTask(task);
    }

    //PUT
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,@Valid @RequestBody Task task){
        Task updated = taskService.updateTask(id, task);
        if (updated != null){
            return updated;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTask (@PathVariable Long id){
        boolean removed = taskService.deleteTask(id);
        if (!removed){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found");
        }
    }

}
