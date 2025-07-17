package com.example.taskmanager.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Task {
    private Long id;

    @NotBlank(message = "Title must not be blank")
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String title;

    @Size(max = 200, message = "Description must not exceed 200 characters")
    private String description;

    private boolean completed;

    public Task(){} // Needed for Spring to deserialize JSON

    public Task(Long id, String title, String description, boolean completed){
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
