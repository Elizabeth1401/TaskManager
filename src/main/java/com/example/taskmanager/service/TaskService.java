package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private long idCounter = 1;

    public List<Task> getAllTasks(){
        return tasks;
    }

    public Task addTask(Task task){
        task.setId(idCounter++);
        tasks.add(task);
        return task;
    }

    public Task updateTask(Long id, Task updatedTask){
        for (Task task : tasks){
            if (task.getId().equals(id)){
                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setCompleted(updatedTask.isCompleted());
                return task;
            }
        }
        return null; // not found
    }

    public boolean deleteTask(Long id){
        return tasks.removeIf(task -> task.getId().equals(id));
    }
}
